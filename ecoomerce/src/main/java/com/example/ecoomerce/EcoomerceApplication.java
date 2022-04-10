package com.example.ecoomerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication// 스프링부트가 시작될때 이어노테이션 찾아서 실행
@EnableEurekaServer// 유레카 서버로써 ㅡ로젝트 기동
public class EcoomerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoomerceApplication.class, args);
    }

}
