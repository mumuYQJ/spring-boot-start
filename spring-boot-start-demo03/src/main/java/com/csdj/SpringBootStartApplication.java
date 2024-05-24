package com.csdj;

import com.csdj.pojo.Pig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(Pig.class)
public class SpringBootStartApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SpringBootStartApplication.class, args);
        String[] beanNamesForType = ioc.getBeanNamesForType(Pig.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}
