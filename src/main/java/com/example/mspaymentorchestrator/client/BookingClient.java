package com.example.mspaymentorchestrator.client;

import com.example.mspaymentorchestrator.dto.TicketOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-booking", url = "http://localhost:8080/api/booking")
public interface BookingClient {
    @PostMapping("/reserve")
    void reserveSeat(@RequestBody TicketOrderDto order);
}
