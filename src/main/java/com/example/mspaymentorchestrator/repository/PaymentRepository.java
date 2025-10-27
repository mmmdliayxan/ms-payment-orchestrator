package com.example.mspaymentorchestrator.repository;


import com.example.mspaymentorchestrator.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
