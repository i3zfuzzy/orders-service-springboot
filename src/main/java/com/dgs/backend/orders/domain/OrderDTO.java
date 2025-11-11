package com.dgs.backend.orders.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.UUID;

public record OrderDTO(
    String id,
    @NotBlank String customer,
    @Min(1) int quantity,
    @Min(0) double unitPrice,
    Instant createdAt
) {
    public static OrderDTO create(String customer, int quantity, double unitPrice) {
        return new OrderDTO(UUID.randomUUID().toString(), customer, quantity, unitPrice, Instant.now());
    }
    public double total() { return quantity * unitPrice; }
}
