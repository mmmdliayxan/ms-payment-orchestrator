package com.example.mspaymentorchestrator.dto.request;

import com.example.mspaymentorchestrator.dto.TicketOrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SagaStartRequest {
    private TicketOrderDto order;
    private PaymentRequest paymentRequest;
}
