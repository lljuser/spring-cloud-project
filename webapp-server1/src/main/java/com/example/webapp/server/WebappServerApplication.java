package com.example.webapp.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.example"})
public class WebappServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebappServerApplication.class, args);
    }
}
