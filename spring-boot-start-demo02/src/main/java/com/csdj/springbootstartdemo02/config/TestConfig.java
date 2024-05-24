package com.csdj.springbootstartdemo02.config;

//import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

@Configuration
//@Import(DruidDataSource.class)
//@EnableConfigurationProperties
public class TestConfig {

//    @Bean
//    @Scope("prototype")
//    public DataSource dataSource() {
//        return new DruidDataSource();
//    }
}
