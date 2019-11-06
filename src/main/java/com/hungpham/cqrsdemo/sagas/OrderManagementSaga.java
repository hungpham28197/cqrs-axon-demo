package com.hungpham.cqrsdemo.sagas;

import com.hungpham.cqrsdemo.core.event.OrderCreatedEvent;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

@Saga
public class OrderManagementSaga {

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        System.out.println("Saga Order Create Event");
        SagaLifecycle.end();
    }
}
