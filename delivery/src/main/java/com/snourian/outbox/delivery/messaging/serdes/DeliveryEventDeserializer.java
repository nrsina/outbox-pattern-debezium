package com.snourian.outbox.delivery.messaging.serdes;

import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper;
import com.snourian.outbox.delivery.messaging.event.DeliveryEvent;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

public class DeliveryEventDeserializer implements Deserializer<DeliveryEvent> {

    private final CBORMapper mapper = new CBORMapper();
    private final static Logger logger = LoggerFactory.getLogger(DeliveryEventDeserializer.class);

    @Override
    public DeliveryEvent deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            return mapper.readValue(data, DeliveryEvent.class);
        } catch (IOException e) {
            logger.error("Error in deserializing DeliveryEvent", e);
            throw new SerializationException("Cannot deserialize data: " + Arrays.toString(data));
        }
    }

    @Override
    public DeliveryEvent deserialize(String topic, Headers headers, byte[] data) {
        return deserialize(topic, data);
    }
}
