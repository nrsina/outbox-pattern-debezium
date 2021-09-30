package com.snourian.outbox.order.outbox;

public class OutboxEvent<T> {

    private String aggregateType;

    private String aggregateId;

    private String type;

    private T payload;

    public String getAggregateType() {
        return aggregateType;
    }

    public OutboxEvent<T> setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
        return this;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public OutboxEvent<T> setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
        return this;
    }

    public String getType() {
        return type;
    }

    public OutboxEvent<T> setType(String type) {
        this.type = type;
        return this;
    }

    public T getPayload() {
        return payload;
    }

    public OutboxEvent<T> setPayload(T payload) {
        this.payload = payload;
        return this;
    }
}
