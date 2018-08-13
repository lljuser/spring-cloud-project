package com.example.webapp.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/eureka")
public class EurekaController {

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/info")
    public List<ServiceInstance> getInfo(){
        return this.discoveryClient.getInstances("webapp-server");
    }

    @RequestMapping(value = "/server")
    public List<ServiceInstance> getServer(){
        return this.discoveryClient.getInstances("eureka-server");
    }

    @RequestMapping(value = "/service")
    public List<String> getService(){
        return this.discoveryClient.getServices();
    }
}
