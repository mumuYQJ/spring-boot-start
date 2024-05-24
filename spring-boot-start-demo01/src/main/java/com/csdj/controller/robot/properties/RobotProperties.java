package com.csdj.controller.robot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("robot")
@Data
public class RobotProperties {

    private String name;
    private int age;
}
