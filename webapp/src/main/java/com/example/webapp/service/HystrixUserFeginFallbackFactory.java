package com.example.webapp.service;

import feign.hystrix.FallbackFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Fallback 回调类 异常处理
 * feign.hystrix.enabled: true
 * **/
@Component
public class HystrixUserFeginFallbackFactory implements FallbackFactory<UserFeignClient> {
    private Log logger= LogFactory.getLog(HystrixUserFeginFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        logger.info("fallback---->",throwable);
        return new HystrixUserFeignClientFallback();
    }
}
