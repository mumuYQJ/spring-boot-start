package com.csdj.springbootrpc.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface WeatherApi {

    @GetExchange(url = "http://ali-weather.showapi.com/area-to-weather-date",accept = "application/json")
    Mono<String> weather(@RequestParam("area") String city);
}
