package com.dgs.backend.orders.api;

import com.dgs.backend.orders.domain.OrderDTO;
import com.dgs.backend.orders.service.OrderService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public record CreateOrderReq(@NotBlank String customer, @Min(1) int quantity, @Min(0) double unitPrice) {}

    public OrderController(OrderService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody CreateOrderReq req) {
        return ResponseEntity.ok(service.create(req.customer(), req.quantity(), req.unitPrice()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> get(@PathVariable String id) {
        return service.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<OrderDTO> list() { return service.list(); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
