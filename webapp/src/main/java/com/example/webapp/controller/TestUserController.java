package com.example.webapp.controller;

import com.example.webapp.logic.model.TestUserModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 微服务调用webapp/testuser/getuser
 * **/
@RestController
@RequestMapping(value = "/testuser")
public class TestUserController {

    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate;

    public TestUserController(RestTemplateBuilder builder, DiscoveryClient client){
        this.restTemplate=builder.build();
        this.discoveryClient=client;
    }

    @RequestMapping(value = "/getuser")
    public TestUserModel getUser(){

        List<String>  services =  this.discoveryClient.getServices();
        System.out.println(services);

        List<ServiceInstance> instances= this.discoveryClient.getInstances("webapp-server");
        System.out.println(instances);

        String url=instances.get(0).getUri().toString();
        TestUserModel user = this.restTemplate.getForObject(url+"/testuser/getuser",TestUserModel.class);
        return user;
    }
}
