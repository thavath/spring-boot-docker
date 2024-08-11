package com.thavath.customers.kafka.impl;

import com.thavath.customers.kafka.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String topic, String key, String value) {
        log.info("Sending data to topic {}", topic);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, value);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[{}] with offset=[{}]", value, result.getRecordMetadata().offset());
            } else {
                log.info("Unable to send message=[{}}] due to : ", ex.getMessage());
            }
        });
    }
}
