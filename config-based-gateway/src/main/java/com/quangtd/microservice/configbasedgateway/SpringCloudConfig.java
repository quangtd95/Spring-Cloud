package com.quangtd.microservice.configbasedgateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/currency-converter/**")
                        .filters(f -> f.addRequestHeader("currency-converter", "hacked by quangtd")
                                .addResponseHeader("currency-converter", "hacked by quangtd")
                                .hystrix(t -> t.setFallbackUri("forward:/fallback/message")))
                        .uri("lb://CURRENCY-CONVERSION-SERVICE")
                        .id("currencyConversion"))
                .route(r -> r.path("/currency-exchange/**")
                        .filters(f -> f.addRequestHeader("currency-exchange", "hacked by quangtd")
                                .hystrix(t -> t.setFallbackUri("forward:/fallback/message"))
                                .addResponseHeader("currency-exchange", "hacked by quangtd"))
                        .uri("lb://FOREX-SERVICE")
                        .id("forex"))
                .build();
    }

}