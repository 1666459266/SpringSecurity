package com.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SecurityEureka7001 {
    public static void main(String[] args) {
        SpringApplication.run(SecurityEureka7001.class,args);
    }
}
