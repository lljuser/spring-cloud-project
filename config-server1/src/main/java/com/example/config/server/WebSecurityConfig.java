package com.example.config.server;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER.NEVER);
        http.csrf().disable();

        http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests()
                .anyRequest().hasRole("ENDPOINT_ADMIN")
                .and()
                .httpBasic();
    }
}
