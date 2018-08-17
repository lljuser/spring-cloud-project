package com.example.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/config")
@RefreshScope
public class ConfigController {
    @Autowired
    Environment environment;

    @RequestMapping(value = "/myname")
    public String getInfo(){
        return "mycluster:" + this.environment.getProperty("spring.mycluster");
    }

    @RequestMapping(value = "/show")
    public String[] all(){
        return  environment.getActiveProfiles();
    }


}
