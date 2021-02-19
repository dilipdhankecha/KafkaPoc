package com.poc.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);
    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public KafkaConsumerService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "shayona", groupId = "group_id")
    public void receiveMessage(String message) {
        LOGGER.info("ConsumerService :: receiveMessage :: Message received from topic ::-> {} With message ::-> {}", "shayona", message);
    }
}
