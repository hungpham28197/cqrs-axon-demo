package com.hungpham.cqrsdemo.aggregates;

import com.hungpham.cqrsdemo.core.OrderStatus;
import com.hungpham.cqrsdemo.core.command.CreateOrderCommand;
import com.hungpham.cqrsdemo.core.event.OrderCreatedEvent;
import com.hungpham.cqrsdemo.model.ItemType;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class OrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private ItemType itemType;
    private BigDecimal price;
    private String currency;
    private OrderStatus orderStatus;

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand) {
        System.out.println("------------> CreateOrderCommand");
        AggregateLifecycle.apply(new OrderCreatedEvent(createOrderCommand.orderId, createOrderCommand.itemType, createOrderCommand.price,
                createOrderCommand.currency, createOrderCommand.orderStatus));
    }

    @EventSourcingHandler
    protected void on(OrderCreatedEvent orderCreatedEvent) {
        this.orderId = orderCreatedEvent.orderId;
        this.currency = orderCreatedEvent.currency;
        this.itemType = orderCreatedEvent.itemType;
        this.orderStatus = orderCreatedEvent.orderStatus;
        this.price = orderCreatedEvent.price;
    }
}
