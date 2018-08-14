package com.example.webapp.service;

import com.example.webapp.config.FeignAuthConfig;
import com.example.webapp.logic.model.TestUserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过FeignClient实现服务调用 通过EanbleFeginClients发现
 * **/
@Service
@FeignClient(name="webapp-server",configuration = FeignAuthConfig.class)
public interface UserFeignClient {
    @RequestMapping("/testuser/getuser")
    public TestUserModel getUser();

}
