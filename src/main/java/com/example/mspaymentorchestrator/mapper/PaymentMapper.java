package com.example.mspaymentorchestrator.mapper;

import com.example.mspaymentorchestrator.dto.request.PaymentRequest;
import com.example.mspaymentorchestrator.model.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    Payment toEntity(PaymentRequest dto);

    PaymentRequest toDto(Payment payment);
}
