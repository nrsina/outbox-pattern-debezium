package com.snourian.outbox.order.web.dto;

import com.snourian.outbox.order.domain.Order;
import com.snourian.outbox.order.domain.OrderStatus;
import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.Min;

@Introspected
public class OrderCreationDto {

    @Min(1)
    private long itemId;

    @Min(1)
    private int quantity;

    @Min(1)
    private long customerId;

    public Order toOrder() {
        Order order = new Order();
        order.setItemId(itemId);
        order.setCustomerId(customerId);
        order.setQuantity(quantity);
        order.setStatus(OrderStatus.PENDING);
        return order;
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
}
