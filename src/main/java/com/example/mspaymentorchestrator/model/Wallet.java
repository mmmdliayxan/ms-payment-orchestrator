package com.example.mspaymentorchestrator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    private Long userId;

    private Double balance;

    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String cvv;
}