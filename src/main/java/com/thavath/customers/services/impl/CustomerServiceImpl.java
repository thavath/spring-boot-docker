package com.thavath.customers.services.impl;

import com.thavath.customers.entities.Customer;
import com.thavath.customers.repositories.CustomerRepository;
import com.thavath.customers.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Mono<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        return customerRepository.save(customer).map(entity -> entity);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Void> delete(String id) {
        return customerRepository.deleteById(id);
    }

    @Override
    public Mono<Customer> findByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }
}
