package com.csdj.config;

import com.csdj.biz.UserHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class MyRouterConfig {
    Logger log = LoggerFactory.getLogger(MyRouterConfig.class);

    @Bean
    public RouterFunction<ServerResponse> router(UserHandle userHandle) {
        return RouterFunctions.route().GET("/login", RequestPredicates.accept(MediaType.ALL), userHandle::login).build();
    }
}
