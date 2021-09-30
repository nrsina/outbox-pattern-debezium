package com.snourian.outbox.order.web.dto;

import com.snourian.outbox.order.domain.Order;
import com.snourian.outbox.order.domain.OrderStatus;

public class OrderCreatedDto {

    private long id;

    private long itemId;

    private int quantity;

    private long customerId;

    private OrderStatus status;

    public static OrderCreatedDto FromOrder(Order order) {
        OrderCreatedDto dto = new OrderCreatedDto();
        dto.id = order.getId();
        dto.itemId = order.getItemId();
        dto.quantity = order.getQuantity();
        dto.customerId = order.getCustomerId();
        dto.status = order.getStatus();
        return dto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
