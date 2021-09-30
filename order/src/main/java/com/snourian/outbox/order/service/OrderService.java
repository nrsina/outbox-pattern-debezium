package com.snourian.outbox.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.snourian.outbox.order.domain.Order;
import com.snourian.outbox.order.outbox.EventDispatcher;
import com.snourian.outbox.order.outbox.OutboxEvent;
import com.snourian.outbox.order.repository.OrderRepository;
import com.snourian.outbox.order.service.event.DeliveryEvent;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;

@Singleton
public class OrderService {

    private final OrderRepository orderRepository;
    private final EventDispatcher eventDispatcher;

    public OrderService(OrderRepository orderRepository, EventDispatcher eventDispatcher) {
        this.orderRepository = orderRepository;
        this.eventDispatcher = eventDispatcher;
    }

    @Transactional
    public Order createOrder(Order newOrder) throws JsonProcessingException {
        final Order savedOrder = orderRepository.save(newOrder);
        eventDispatcher.dispatch(new OutboxEvent<DeliveryEvent>()
                .setAggregateType(Order.class.getSimpleName().toLowerCase())
                .setAggregateId(String.valueOf(savedOrder.getId()))
                .setType("OrderPlaced")
                .setPayload(new DeliveryEvent(savedOrder.getId(), savedOrder.getCustomerId())));
        return savedOrder;
    }
}
