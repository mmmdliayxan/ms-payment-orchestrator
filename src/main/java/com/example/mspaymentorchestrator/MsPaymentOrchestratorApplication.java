package com.example.mspaymentorchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.mspaymentorchestrator.client")
public class MsPaymentOrchestratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPaymentOrchestratorApplication.class, args);
    }

}
