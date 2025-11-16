package com.example.kafka_demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final String TOPIC = "notification-topic";
    private static final String GROUP_ID = "my-json-group";

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consumeMessage(NotificationRequest receivedRequest){
        System.out.println("📥 Message Received (JSON): " + receivedRequest);
    }

}
