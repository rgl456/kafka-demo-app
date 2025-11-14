package com.example.kafka_demo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    private static final String TOPIC = "basic-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send/{message}")
    public String sendMessage(@PathVariable String message){
        try{
            kafkaTemplate.send(TOPIC, message);
            System.out.println("📤 Message Sent: " + message);
            return "SUCCESS: Message sent to Kafka!";
        }
        catch (Exception e){
            System.err.println("❌ Error sending message: " + e.getMessage());
            return "ERROR: " + e.getMessage();
        }
    }
}
