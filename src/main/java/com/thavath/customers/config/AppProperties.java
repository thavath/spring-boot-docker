package com.thavath.customers.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AppProperties {
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;
    @Value(value = "${spring.kafka.topic}")
    private String topic;
    @Value(value = "${spring.kafka.consumer.group}")
    private String group;
}
