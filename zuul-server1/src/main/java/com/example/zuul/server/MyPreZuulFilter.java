package com.example.zuul.server;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义ZuulFilter 实现请求的拦截
 * 通过RequestContext获取请求信息
 * **/

public class MyPreZuulFilter extends ZuulFilter {
    private final  static Log logger= LogFactory.getLog(MyPreZuulFilter.class);

    /**
     * 拦截类型pre->route->post->error
     * **/
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();
        logger.info(String.format("send %s request to %s",request.getMethod(),request.getRequestURL().toString()));
        return null;
    }
}
