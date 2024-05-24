package com.csdj.controller.robot.service;

import com.csdj.controller.robot.properties.RobotProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {

    @Autowired
    private RobotProperties robotProperties;

    public String hello() {
        return "姓名：" + robotProperties.getName() + ",年龄：" + robotProperties.getAge();
    }
}
