package com.order_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable int id) {

        String userResponse = restTemplate.getForObject(
            "http://user-service.local:8080/users/" + id,
            String.class
        );

        return "Order Service → " + userResponse;
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
