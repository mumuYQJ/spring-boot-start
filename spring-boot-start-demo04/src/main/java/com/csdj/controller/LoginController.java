package com.csdj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@ResponseBody
@RequestMapping(value = "/user")
//@RequestMapping(value = "/user",produces = "text/html")
public class LoginController {

    @RequestMapping("/login")
    public String login(String name,String password) {
        return "姓名：" + name + "密码：" + password;
    }
}
