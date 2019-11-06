package com.hungpham.cqrsdemo.service;

import com.hungpham.cqrsdemo.core.OrderStatus;
import com.hungpham.cqrsdemo.core.command.CreateOrderCommand;
import com.hungpham.cqrsdemo.model.OrderDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class OrderServiceImpl implements OrderService {
    private final CommandGateway commandGateway;

    public OrderServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> create(OrderDTO orderDTO) {
        return commandGateway.send(new CreateOrderCommand(orderDTO.getOrderId(), orderDTO.getItemType(), orderDTO.getPrice(), orderDTO.getCurrency(), OrderStatus.CREATED));
    }
}
