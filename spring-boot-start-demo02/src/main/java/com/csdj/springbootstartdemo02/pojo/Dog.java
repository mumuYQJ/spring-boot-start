package com.csdj.springbootstartdemo02.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
public class Dog {

    private String name;
}
