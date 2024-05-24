package com.csdj.springbootsecurity.controller;

import com.csdj.springbootsecurity.component.CountComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private CountComponent component;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
//    @PreAuthorize("hasAuthority('write_file')")
    @Secured("ROLE_HR")
    public String hello() {
        return "Hello,world";
    }

    @GetMapping("/login")
    public Object login() {
        return "login";
    }

//    @ResponseBody
//    @RequestMapping("/submit")
//    public String submit() {
//        return "登录成功！";
//    }

    @GetMapping("/count")
    @ResponseBody
    public String count() {
        component.count();
        return "count";
    }
}
