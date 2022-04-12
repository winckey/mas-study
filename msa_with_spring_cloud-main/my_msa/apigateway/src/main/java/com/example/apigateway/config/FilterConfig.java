package com.example.apigateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration//yml에  등록할것을 config파일로 등록
public class FilterConfig {

//    @Bean//RouteLocatorBuilder
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()//라우터 경로
                .route(r -> r.path("/first-service/**")//이경로이면 이하(filters) 작업
                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")
                                .addResponseHeader("first-response", "first-response-header"))
                        .uri("http://localhost:8081"))// 필터를 거치고 uri로 이동
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8082"))
                .build();
    }


}
