package com.example.webapp.service;

import com.example.webapp.config.FeignAuthConfig;
import com.example.webapp.logic.model.TestUserModel;
import com.example.webapp.model.HealthModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过FeignClient实现服务调用 通过EanbleFeginClients发现
 *
 * HystrixCommand隔离策略有两种SEMAPHORE与THREAD
 * @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
 *
 * THREAD策略不支持线程上下文的传递，如果要传上递需要开启
 * hystrix.shareSecurityContext： true
 *
 * 如果要支持并发策略的上下文传递还要注入HystrixConcurrencyStrategy 替换默认的策略
 * **/
@Service
@FeignClient(name="webapp-server",
        configuration = FeignAuthConfig.class,
        fallback = HystrixUserFeignClientFallback.class)
public interface UserFeignClient {

    /**
     * 使用不同的隔离策略
     * **/
    @RequestMapping("/testuser/getuser")
    @HystrixCommand(fallbackMethod = "stubMyService",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
            }
    )
    public TestUserModel getUser();

    @RequestMapping("/sidecar/health")
    public HealthModel getHealth();

}
