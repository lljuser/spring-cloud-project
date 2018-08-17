package com.example.zuul.server;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyPostZuulFilter extends ZuulFilter {
    private Log logger= LogFactory.getLog(MyPostZuulFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("add custom header X-ZUUL-MYNAME to response");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse servletResponse=context.getResponse();

        logger.info("----------->"+ servletResponse.getStatus());


        servletResponse.addHeader("X-ZUUL-MYNAME","LLJ");
        return null;
    }
}
