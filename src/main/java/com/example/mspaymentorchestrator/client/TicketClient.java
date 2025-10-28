package com.example.mspaymentorchestrator.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-ticket", url = "http://ms-gateway:8080/api/tickets")
public interface TicketClient {
    @PutMapping("/{orderId}/status/{status}")
    void updateStatus(@PathVariable Long orderId, @PathVariable String status);
}