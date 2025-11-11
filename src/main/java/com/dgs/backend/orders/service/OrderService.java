package com.dgs.backend.orders.service;

import com.dgs.backend.orders.domain.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {
    private final Map<String, OrderDTO> store = new ConcurrentHashMap<>();

    public OrderDTO create(String customer, int quantity, double unitPrice) {
        OrderDTO o = OrderDTO.create(customer, quantity, unitPrice);
        store.put(o.id(), o);
        return o;
    }

    public Optional<OrderDTO> get(String id) { return Optional.ofNullable(store.get(id)); }
    public List<OrderDTO> list() { return new ArrayList<>(store.values()); }
    public boolean delete(String id) { return store.remove(id) != null; }
}
