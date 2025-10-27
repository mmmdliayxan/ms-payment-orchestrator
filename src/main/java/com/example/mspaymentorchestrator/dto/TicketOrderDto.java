package com.example.mspaymentorchestrator.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TicketOrderDto {
    private Long id;
    private Long userId;
    private Long ticketId;
    private String userPhone;
    private Integer quantity;
    private BigDecimal totalPrice;
}
