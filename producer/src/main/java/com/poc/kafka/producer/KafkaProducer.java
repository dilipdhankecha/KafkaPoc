package com.poc.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final String TOPIC = "shayona";
    private final KafkaTemplate kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(String message) {
        LOGGER.info("ProducerService :: publishMessage :: Message sent from topic ::-> {} With message ::-> {}", TOPIC, message);
        kafkaTemplate.send(TOPIC, message);
    }
}
