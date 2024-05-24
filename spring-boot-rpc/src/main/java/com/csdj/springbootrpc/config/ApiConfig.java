package com.csdj.springbootrpc.config;

import com.csdj.springbootrpc.service.NoteApi;
import com.csdj.springbootrpc.service.WeatherApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Configuration
public class ApiConfig {

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory(@Value("${aliyun.code}")String appcode) {
        WebClient client = WebClient.builder()
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add("Authorization","APPCODE " + appcode);
//                    httpHeaders.add("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
//                    httpHeaders.add("Content-Type","application/json");
                })
                .codecs(clientCodecConfigurer ->
                    clientCodecConfigurer.defaultCodecs()
                                         .maxInMemorySize(256 * 1024 * 1024)).build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();
        return factory;
    }

    @Bean
    public NoteApi noteApi(HttpServiceProxyFactory factory) {
        return factory.createClient(NoteApi.class);
    }


    @Bean
    public WeatherApi weatherApi(HttpServiceProxyFactory factory) {
        return factory.createClient(WeatherApi.class);
    }
}
