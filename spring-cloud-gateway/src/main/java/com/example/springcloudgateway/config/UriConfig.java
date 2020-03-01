package com.example.springcloudgateway.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UriConfig {
    private String httpbin = "http://httpbin.org:80";

    public String getHttpbin() {
        return httpbin;
    }

    public void setHttpbin(String httpbin) {
        this.httpbin = httpbin;
    }
}