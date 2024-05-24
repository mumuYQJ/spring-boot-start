package com.csdj.springbootrpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    @Autowired
    private WeatherApi weatherApi;

    /**
     * 请求的五个元素
     * 1.请求路径
     * 2.请求方式
     * 3.请求参数
     * 4.请求头
     * 5.请求体
     */
    /**
     * 天气调用
     * 参考API接口指南
     * @param city 城市名
     * @return
     */
    /**
     * WebClient客户端的方式
     * @param city
     * @return
     */
//    public Mono<String> weather(String city) {
//        Map<String,String> uriVariables = new HashMap<>();
//        uriVariables.put("area",city);
//        WebClient webClient = WebClient.create();
//        Mono<String> mono = webClient.get()
//                .uri("http://ali-weather.showapi.com/area-to-weather-date?area={area}",uriVariables)
//                .accept(MediaType.APPLICATION_JSON)
//                .header("Authorization", "APPCODE 76e52e49bc594abbb6fbfb955254969b")
//                .retrieve()
//                .bodyToMono(String.class);
//        return mono;
//    }


    public Mono<String> weather(String city) {
        return weatherApi.weather(city);
    }


}
