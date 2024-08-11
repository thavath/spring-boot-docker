package com.thavath.customers.services;

import com.thavath.customers.entities.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Mono<Customer> findById(String id);
    Mono<Customer> findByEmail(String email);
    Mono<Customer> save(Customer customer);
    Mono<Customer> update(Customer customer);
    Mono<Void> delete(String id);
    Mono<Customer> findByPhone(String phone);
    Flux<Customer> findAll();
}
