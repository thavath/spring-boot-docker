package com.thavath.customers.repositories;

import com.thavath.customers.entities.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {
    Mono<Customer> findByEmail(String email);
    Mono<Customer> findByPhone(String phone);
}
