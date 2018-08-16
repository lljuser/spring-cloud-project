package com.example.webappsidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
public class WebappSidecarApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebappSidecarApplication.class, args);
    }
}
