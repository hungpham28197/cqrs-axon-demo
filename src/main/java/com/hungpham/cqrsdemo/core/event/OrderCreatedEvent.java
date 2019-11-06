package com.hungpham.cqrsdemo.core.event;

import com.hungpham.cqrsdemo.core.OrderStatus;
import com.hungpham.cqrsdemo.model.ItemType;

import java.math.BigDecimal;

public class OrderCreatedEvent {
    public final String orderId;
    public final ItemType itemType;
    public final BigDecimal price;
    public final String currency;
    public final OrderStatus orderStatus;

    public OrderCreatedEvent(String orderId, ItemType itemType, BigDecimal price, String currency, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.itemType = itemType;
        this.price = price;
        this.currency = currency;
        this.orderStatus = orderStatus;
    }
}
