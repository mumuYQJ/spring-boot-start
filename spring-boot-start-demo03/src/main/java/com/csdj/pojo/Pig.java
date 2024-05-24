package com.csdj.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("pig")
//@Component
@Data
public class Pig {

    private String id;
    private String name;
    private Integer age;
}
