package com.csdj.springbootrpc.controller;

import com.csdj.springbootrpc.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/weather")
    public Mono<String> weather(@RequestParam(value = "city", required = false) String city) {
        return weatherService.weather(city);
    }
}
