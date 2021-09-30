package com.snourian.outbox.order.outbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper;
import com.snourian.outbox.order.outbox.model.Outbox;
import com.snourian.outbox.order.outbox.repository.OutboxRepository;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.UUID;

@Singleton
public class EventDispatcher {

    private final OutboxRepository outboxRepository;
    private final CBORMapper mapper = new CBORMapper();

    private final Logger logger = LoggerFactory.getLogger(EventDispatcher.class);

    public EventDispatcher(OutboxRepository outboxRepository) {
        this.outboxRepository = outboxRepository;
    }

    @Transactional(Transactional.TxType.MANDATORY)
    public <T> void dispatch(OutboxEvent<T> event) throws JsonProcessingException {
        Outbox outbox = new Outbox();
        outbox.setId(UUID.randomUUID());
        outbox.setAggregateType(event.getAggregateType());
        outbox.setAggregateId(event.getAggregateId());
        outbox.setType(event.getType());
        outbox.setPayload(mapper.writeValueAsBytes(event.getPayload()));
        outboxRepository.save(outbox);
        logger.info("Persisted event [{}, {}] inside the Outbox table", event.getAggregateType(), event.getAggregateId());
    }
}
