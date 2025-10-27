package com.example.mspaymentorchestrator.dto.request;

import com.example.mspaymentorchestrator.model.PaymentStatus;
import lombok.Data;

@Data
public class PaymentRequest {
    private Long userId;
    private Double amount;
    private String cardNumber;
}
