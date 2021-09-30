package com.snourian.outbox.order.outbox.repository;

import com.snourian.outbox.order.outbox.model.Outbox;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface OutboxRepository extends JpaRepository<Outbox, UUID> {
}
