package com.example.webapp.controller;

import com.example.webapp.logic.model.TestUserModel;
import com.example.webapp.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过Fegin 远程调用服务
 * **/
@RestController
@RequestMapping(value = "/feign")
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/getuser")
    public TestUserModel getUser(){
        return this.userFeignClient.getUser();
    }



}
