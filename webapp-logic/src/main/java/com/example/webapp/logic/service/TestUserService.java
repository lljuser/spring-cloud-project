package com.example.webapp.logic.service;

import com.example.common.FrameworkLog;
import com.example.webapp.logic.model.TestUserModel;
import org.springframework.stereotype.Service;

@Service
public class TestUserService {
    public TestUserModel getUser(){
        TestUserModel user =new TestUserModel();
        user.setName("llj");
        FrameworkLog.info(user);
        return user;
    }

}
