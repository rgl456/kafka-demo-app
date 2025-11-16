package com.example.kafka_demo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    private static final String TOPIC = "notification-topic";

    private final KafkaTemplate<String, NotificationRequest> kafkaTemplate;

    public KafkaProducerController(KafkaTemplate<String, NotificationRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody NotificationRequest request){
        try{
            kafkaTemplate.send(TOPIC, request);
            System.out.println("📤 Message Sent (JSON): " + request);
            return "SUCCESS: Notification object sent to Kafka!";

        } catch (Exception e) {
            System.err.println("❌ Error sending JSON message: " + e.getMessage());
            return "ERROR: " + e.getMessage();
        }
    }
}
