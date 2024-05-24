package com.csdj.springbootstartdemo02.config;

import com.csdj.springbootstartdemo02.pojo.Cat;
import com.csdj.springbootstartdemo02.pojo.Dog;
import com.csdj.springbootstartdemo02.pojo.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

//@SpringBootConfiguration
public class TestConfig01 {

    @ConditionalOnClass(name = "com.alibaba.druid.pool.DruidDataSource")
    @Bean
    public Cat cat01() {
        return new Cat();
    }

    @ConditionalOnMissingClass("com.alibaba.druid.pool.DruidDataSource")
    @Bean
    public Dog dog01() {
        return new Dog();
    }

    @ConditionalOnBean(name = "dog01")
    @Bean
    public User zhangsan() {
        return new User();
    }

    @ConditionalOnMissingBean(name = "dog01")
    @Bean
    public User lisi() {
        return new User();
    }


}
