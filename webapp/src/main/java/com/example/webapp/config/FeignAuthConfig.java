package com.example.webapp.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定Fegin配置，实现对有权限的服务调  Basic或Token
 * 开启日志 每个FeginClient有自己的日志 即类名 要在yml开启对应类的日志
 * **/
@Configuration
public class FeignAuthConfig implements IFeignConfig {
    /**
     * 通过配置实现每个FeginClient日志开关
     * **/
   /* @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }*/

    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new FeignBasicAuthRequestInterceptor();
    }

    class FeignBasicAuthRequestInterceptor implements RequestInterceptor{

        @Override
        public void apply(RequestTemplate requestTemplate) {
            requestTemplate.header("Authorization","xxxxxxxxx");
        }
    }
}
