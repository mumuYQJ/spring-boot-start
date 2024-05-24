package com.csdj.springbootstartdemo02.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties("user")
public class User {
    private int id;
    private String uname;
    private List<Cat> cats;
    private Dog dog;
    private Map<String,Cat> map;
}
