package com.example.example_service_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExampleServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleServiceAApplication.class, args);
    }

}
