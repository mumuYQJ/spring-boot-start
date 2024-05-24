package com.csdj.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class UserHandle {
    private Logger logger = LoggerFactory.getLogger(UserHandle.class);

    public ServerResponse login(ServerRequest request) {
        logger.info("登录成功 ----> UserHandle");
        return ServerResponse.ok().build();
    }
}
