package com.snourian.outbox.delivery.repository;

import com.snourian.outbox.delivery.domain.Delivery;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
