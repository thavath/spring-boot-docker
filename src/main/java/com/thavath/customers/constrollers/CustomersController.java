package com.thavath.customers.constrollers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thavath.customers.config.AppProperties;
import com.thavath.customers.entities.Customer;
import com.thavath.customers.kafka.ProducerService;
import com.thavath.customers.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomersController {
    private final CustomerService customerService;
    private final ProducerService producerService;
    private final AppProperties appProperties;
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    @GetMapping("{id}")
    public Mono<Customer> findById(@PathVariable("id") String id){
        return customerService.findById(id);
    }
    @GetMapping("email/{email}")
    public Mono<Customer> findByEmail(@PathVariable("email") String email) {
        return customerService.findByEmail(email);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customer> save(@RequestBody Customer customer){
         producerService.send(appProperties.getTopic(), customer.getName(), gson.toJson(customer));
        return customerService.save(customer);
    }
    @PutMapping
    public Mono<Customer> update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }
    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return customerService.delete(id);
    }
    @GetMapping("phone/{phone}")
    public Mono<Customer> findByPhone(@PathVariable("phone") String phone){
        return customerService.findByPhone(phone);
    }
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> findAll(){
        return customerService.findAll().delayElements(Duration.ofSeconds(1));
    }
}
