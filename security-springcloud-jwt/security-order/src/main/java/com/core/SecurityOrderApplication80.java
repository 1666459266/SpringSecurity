package com.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SecurityOrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(SecurityOrderApplication80.class,args);
    }
}
