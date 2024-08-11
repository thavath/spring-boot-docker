package com.thavath.customers.data;

import com.thavath.customers.entities.Customer;
import com.thavath.customers.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataSeeker implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {
        var count = customerRepository.count().block();
        if (count == 0){
            for (int i = 0; i < 10; i++) {
                customerRepository.save(
                        Customer.builder()
                                .id(UUID.randomUUID().toString())
                                .name("Name" + i)
                                .phone("Phone" + i)
                                .email("Email" + i + "@gmail.com")
                                .gender("Male")
                                .isNewEntry(true)
                                .build()
                ).subscribe();
            }
        }
    }
}
