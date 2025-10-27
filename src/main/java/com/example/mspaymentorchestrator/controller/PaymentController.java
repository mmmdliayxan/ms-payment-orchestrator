package com.example.mspaymentorchestrator.controller;


import com.example.mspaymentorchestrator.dto.TicketOrderDto;
import com.example.mspaymentorchestrator.dto.request.PaymentRequest;
import com.example.mspaymentorchestrator.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/saga")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService sagaService;

    @PostMapping("/start")
    public ResponseEntity<String> startSaga(@RequestBody TicketOrderDto order,
                                            @RequestBody PaymentRequest paymentRequest) {
        sagaService.startSaga(order,paymentRequest);
        return ResponseEntity.ok("Saga started for orderId=" + order.getTicketId());
    }

}