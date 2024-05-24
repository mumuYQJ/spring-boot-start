package com.csdj.controller;

import com.csdj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    
    @RequestMapping("/test")
    @ResponseBody
    public Object add(StringRedisTemplate stringRedisTemplate) {
        User user = new User();
        user.setName("张三");
        user.setSex("女");
        user.setAge(17);
        return user;
    }
}
