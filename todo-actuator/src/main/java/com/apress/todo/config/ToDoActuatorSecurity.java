package com.apress.todo.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class ToDoActuatorSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .requestMatcher(EndpointRequest.toAnyEndpoint())
                .authorizeRequests()
                .anyRequest().hasRole("ENDPOINT_ADMIN")
                .and()
                .httpBasic();
    }
}
