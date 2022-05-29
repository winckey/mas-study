package com.example.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//유레카 등록
public class Service1Application {

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }

}
