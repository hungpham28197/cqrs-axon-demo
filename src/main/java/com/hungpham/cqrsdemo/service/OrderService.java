package com.hungpham.cqrsdemo.service;

import com.hungpham.cqrsdemo.model.OrderDTO;

import java.util.concurrent.CompletableFuture;

public interface OrderService {
    CompletableFuture<String> create(OrderDTO orderDTO);
}
