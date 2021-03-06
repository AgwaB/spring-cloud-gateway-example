package com.example.example_service_b.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-b")
public class HealthController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello it's service b";
    }

    @GetMapping("/healthz")
    @ResponseStatus(value = HttpStatus.OK)
    public void health() {
    }
}

