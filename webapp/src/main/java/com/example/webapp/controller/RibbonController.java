package com.example.webapp.controller;

import com.example.webapp.logic.model.TestUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 测试ribbon loadbanlancered 根据服务名调用
     * **/
    @RequestMapping(value = "/getuser")
    public TestUserModel getUser(){
        TestUserModel userModel=this.restTemplate.getForObject(
                "http://webapp-server/testuser/getuser",
                 TestUserModel.class);

        return userModel;
    }

    /**
     * 测试查看ribbon的切换
     * **/
    @RequestMapping(value = "/service")
    public String getServiceInfo(){
        ServiceInstance serviceInstance=this.loadBalancerClient.choose("webapp-server");
        return String.format(serviceInstance.getServiceId()+":"
                +serviceInstance.getHost()+":"+serviceInstance.getPort());
    }
}
