package com.example.webapp.controller;

import com.example.webapp.logic.model.TestUserModel;
import com.example.webapp.model.HealthModel;
import com.example.webapp.service.UserFeignClient;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

import java.util.HashMap;

/**
 * 对多个微服务的并发聚合调用  聚合调用示例 Observable
 * **** 聚合并发调用会用到rx.Observable对象转换消息
 * 此库存在reactio库包中，通过引用Hystrix包可引入此包
 * spring-cloud-starter-netflix-hystrix
 * **/
@RestController
@RequestMapping(value = "/aggre")
public class AggregationController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/get")
    public Observable<HashMap<String,Object>> get(){
        Observable<TestUserModel> o1 = Observable.create(observer->{
            TestUserModel user = userFeignClient.getUser();
            observer.onNext(user);
            observer.onCompleted();
        });

        Observable<HealthModel> o2 = Observable.create(observer->{
            HealthModel status = userFeignClient.getHealth();
            observer.onNext(status);
            observer.onCompleted();
        });

        return Observable.zip(o1,o2,(d1,d2)->{
            HashMap<String,Object> map= new HashMap<>();
            map.put("user",d1);
            map.put("status",d2);
            return map;
        });

    }
}
