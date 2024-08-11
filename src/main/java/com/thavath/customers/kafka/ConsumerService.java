package com.thavath.customers.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@EnableKafka
@Configuration
public class ConsumerService {
    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group}")
    public void listenGroupFoo(String message) {
        log.info("Received Message in group: {}", message);
    }
}
