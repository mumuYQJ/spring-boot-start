package com.csdj.controller.robot.controller;

import com.csdj.controller.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {

    @Autowired
    private RobotService robotService;

    @GetMapping("/helloRobot")
    public String helloRobot() {
        return robotService.hello();
    }
}
