package com.csdj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public HelloController() {
        System.out.println("构造方法被调用....");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello,Spring Boot 3!";
    }

}
