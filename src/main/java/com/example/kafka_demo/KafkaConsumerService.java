package com.example.kafka_demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final String TOPIC = "basic-topic";
    private static final String GROUP_ID = "my-basic-group";

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consumeMessage(String receivedMessage){
        System.out.println("📥 Message Received: " + receivedMessage);
    }

}
