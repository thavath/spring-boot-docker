package com.thavath.customers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;

@Slf4j
@SpringBootApplication(exclude = { ReactiveUserDetailsServiceAutoConfiguration.class})
public class CustomerMicroservicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroservicesApplication.class, args);
	}

}
