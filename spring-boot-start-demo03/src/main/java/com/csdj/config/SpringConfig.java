package com.csdj.config;

import com.csdj.pojo.Pig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

//@SpringBootConfiguration
public class SpringConfig {

//    @ConfigurationProperties("pig")
    @Bean
    public Pig pig() {
        return new Pig();
    }


}
