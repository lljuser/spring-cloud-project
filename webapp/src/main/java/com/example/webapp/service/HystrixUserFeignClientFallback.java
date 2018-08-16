package com.example.webapp.service;

import com.example.webapp.logic.model.TestUserModel;
import com.example.webapp.model.HealthModel;
import org.springframework.stereotype.Component;

/**
 * Fallback 回调类 不带异常处理
 * feign.hystrix.enabled: true
 * **/
@Component
public class HystrixUserFeignClientFallback implements UserFeignClient {
    @Override
    public TestUserModel getUser() {
        TestUserModel testUserModel=new TestUserModel();
        testUserModel.setName("i am fallback test");
        return testUserModel;
    }

    @Override
    public HealthModel getHealth() {
        HealthModel healthModel=new HealthModel();
        healthModel.setStatus("DOWN");
        return healthModel;
    }
}
