package com.thavath.customers.kafka;

public interface ProducerService {
    void send(String topic, String key, String value);
}
