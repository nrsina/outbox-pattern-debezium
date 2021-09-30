package com.snourian.outbox.order.service.event;

public class DeliveryEvent {

    private long orderId;
    private long customerId;

    public DeliveryEvent() {
    }

    public DeliveryEvent(long orderId, long customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public long getOrderId() {
        return orderId;
    }

    public DeliveryEvent setOrderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    public long getCustomerId() {
        return customerId;
    }

    public DeliveryEvent setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }
}
