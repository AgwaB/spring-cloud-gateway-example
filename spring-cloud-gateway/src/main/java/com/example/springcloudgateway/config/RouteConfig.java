package com.example.springcloudgateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Autowired
    private UriConfig uriConfig;
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUri = uriConfig.getHttpbin();
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                /*
                $ curl http://localhost:8080/get
                 */
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f.hystrix(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                /*
                $ curl --dump-header - --header 'Host: www.hystrix.com' http://localhost:8080/delay/3
                 */
                .build();
    }
}