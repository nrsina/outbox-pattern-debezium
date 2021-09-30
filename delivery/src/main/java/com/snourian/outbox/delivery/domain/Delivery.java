package com.snourian.outbox.delivery.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DELIVERY")
public class Delivery {

    @Id
    @GeneratedValue(generator = "DELIVERY_SEQ")
    @GenericGenerator(
            name = "DELIVERY_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "10"),
                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled-lo")
            }
    )
    private Long id;

    private long orderId;

    private long customerId;

    public Delivery() {
    }

    public Delivery(long orderId, long customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public Delivery setId(Long id) {
        this.id = id;
        return this;
    }

    public long getOrderId() {
        return orderId;
    }

    public Delivery setOrderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    public long getCustomerId() {
        return customerId;
    }

    public Delivery setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }
}
