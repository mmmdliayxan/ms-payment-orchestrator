package com.example.mspaymentorchestrator.service;

import com.example.mspaymentorchestrator.client.BookingClient;
import com.example.mspaymentorchestrator.client.TicketClient;
import com.example.mspaymentorchestrator.dto.TicketOrderDto;
import com.example.mspaymentorchestrator.dto.request.PaymentRequest;
import com.example.mspaymentorchestrator.mapper.PaymentMapper;
import com.example.mspaymentorchestrator.model.Payment;
import com.example.mspaymentorchestrator.model.PaymentStatus;
import com.example.mspaymentorchestrator.model.Wallet;
import com.example.mspaymentorchestrator.repository.PaymentRepository;
import com.example.mspaymentorchestrator.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final WalletRepository walletRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;
    private final TicketClient ticketClient;
    private final BookingClient bookingClient;

    @Transactional
    public void startSaga(TicketOrderDto order, PaymentRequest paymentDTO) {
        log.info("SAGA started for orderId={} userId={}", order.getId(), order.getUserId());

        Wallet wallet = walletRepository.findById(order.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Wallet not found"));

        if (!wallet.getCardNumber().equals(paymentDTO.getCardNumber())) {
            log.warn("Payment FAILED for orderId={} (card mismatch)", order.getId());
            ticketClient.updateStatus(order.getId(), "FAILED");
            return;
        }

        if (wallet.getBalance() < paymentDTO.getAmount()) {
            log.warn("Payment FAILED for orderId={} (insufficient balance)", order.getId());
            ticketClient.updateStatus(order.getId(), "FAILED");
            return;
        }

        wallet.setBalance(wallet.getBalance() - paymentDTO.getAmount());
        walletRepository.save(wallet);

        Payment payment = mapper.toEntity(paymentDTO);
        payment.setUserId(order.getUserId());
        payment.setStatus(PaymentStatus.SUCCESS);
        paymentRepository.save(payment);

        ticketClient.updateStatus(order.getId(), "CONFIRMED");

        bookingClient.reserveSeat(order);

        log.info("Payment SUCCESS for orderId={} userId={}", order.getId(), order.getUserId());
    }
}
