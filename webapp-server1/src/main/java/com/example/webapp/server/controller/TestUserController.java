package com.example.webapp.server.controller;

import com.example.webapp.logic.model.TestUserModel;
import com.example.webapp.logic.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testuser")
public class TestUserController {
    @Autowired
    private TestUserService testUserService;

    @RequestMapping(value = "/getuser")
    public TestUserModel getUser(){
        return this.testUserService.getUser();
    }
}
