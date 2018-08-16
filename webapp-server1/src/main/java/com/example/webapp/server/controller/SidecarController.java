package com.example.webapp.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sidecar")
public class SidecarController {

    @RequestMapping(value = "/health")
    public HealthJson health(){
        HealthJson json=new HealthJson();
        json.setStatus("UP");
        return  json;
    }


}
