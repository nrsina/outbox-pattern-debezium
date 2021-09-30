package com.snourian.outbox.delivery.service;

import com.snourian.outbox.delivery.domain.Delivery;
import com.snourian.outbox.delivery.repository.DeliveryRepository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;

@Singleton
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Transactional
    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }
}
