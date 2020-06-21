package com.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = {"com.core"})
public class SecurityUaaApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(SecurityUaaApplication8080.class,args);
    }
}
