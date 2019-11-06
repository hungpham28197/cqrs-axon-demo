package com.hungpham.cqrsdemo.core.command;

import com.hungpham.cqrsdemo.core.OrderStatus;
import com.hungpham.cqrsdemo.model.ItemType;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

public class CreateOrderCommand {
    @TargetAggregateIdentifier
    public final String orderId;
    public final ItemType itemType;
    public final BigDecimal price;
    public final String currency;
    public final OrderStatus orderStatus;

    public CreateOrderCommand(String orderId, ItemType itemType, BigDecimal price, String currency, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.itemType = itemType;
        this.price = price;
        this.currency = currency;
        this.orderStatus = orderStatus;
    }
}
