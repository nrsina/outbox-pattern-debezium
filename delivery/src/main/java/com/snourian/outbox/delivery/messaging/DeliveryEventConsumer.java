package com.snourian.outbox.delivery.messaging;

import com.snourian.outbox.delivery.domain.Delivery;
import com.snourian.outbox.delivery.messaging.event.DeliveryEvent;
import com.snourian.outbox.delivery.service.DeliveryService;
import io.micronaut.configuration.kafka.annotation.*;
import io.micronaut.context.annotation.Property;
import io.micronaut.messaging.annotation.MessageBody;
import io.micronaut.messaging.annotation.MessageHeader;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KafkaListener(groupId = "delivery_group4",
        threads = 1,
        offsetStrategy = OffsetStrategy.SYNC,
        properties = {
                @Property(name = ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, value = "com.snourian.outbox.delivery.messaging.serdes.DeliveryEventDeserializer"),
                @Property(name = ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, value = "org.apache.kafka.common.serialization.StringDeserializer")
        })
public class DeliveryEventConsumer {

    private final DeliveryService deliveryService;
    private final Logger logger = LoggerFactory.getLogger(DeliveryEventConsumer.class);

    public DeliveryEventConsumer(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Topic(patterns = "outbox.event.order")
    public void receive(@KafkaKey String key,
                        @MessageHeader("id") String aggregateId,
                        @MessageHeader("eventType") String eventType,
                        @MessageBody DeliveryEvent deliveryEvent) {
        logger.info("Received a Kafka event | aggregateId: {}, EventType: {}, payload: {}", aggregateId, eventType, deliveryEvent.toString());
        deliveryService.createDelivery(new Delivery(deliveryEvent.getOrderId(), deliveryEvent.getCustomerId()));
    }
}
