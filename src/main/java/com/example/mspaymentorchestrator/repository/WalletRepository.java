package com.example.mspaymentorchestrator.repository;


import com.example.mspaymentorchestrator.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {}