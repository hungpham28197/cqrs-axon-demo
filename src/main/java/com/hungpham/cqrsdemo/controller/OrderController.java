package com.hungpham.cqrsdemo.controller;

import com.hungpham.cqrsdemo.model.OrderDTO;
import com.hungpham.cqrsdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping()
    public String create(OrderDTO orderDTO) {
        return orderService.create(orderDTO).join();
    }
}
