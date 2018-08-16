package com.example.zuul.server;

import org.springframework.cloud.netflix.zuul.filters.post.LocationRewriteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {
    /**
     * 当通过3XX重定向时，需要重写header,否则会重定向到web url而不是zuul
     * 防止重定向到后端服务器上
     *
     * 使用这个仔细筛选。过滤器作用于所有3XX响应代码的位置标头
     * 不适用于所有场景，例如当将用户重定向到外部URL时。
     * **/
    @Bean
    public LocationRewriteFilter locationRewriteFilter(){
        return new LocationRewriteFilter();
    }

    @Bean
    public MyPreZuulFilter myPreZuulFilter(){
        return new MyPreZuulFilter();
    }

    @Bean
    public MyFallbackProvider myFallbackProvider(){
        return new MyFallbackProvider();
    }

    @Bean
    public MyPostZuulFilter myPostZuulFilter(){
        return new MyPostZuulFilter();
    }
}
