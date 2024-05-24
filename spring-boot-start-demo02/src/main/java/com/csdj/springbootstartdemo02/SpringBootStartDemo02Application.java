package com.csdj.springbootstartdemo02;

//import com.csdj.springbootrobot.robot.EnableRobot;
import com.csdj.springbootstartdemo02.pojo.Cat;
import com.csdj.springbootstartdemo02.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Random;

@SpringBootApplication
public class SpringBootStartDemo02Application {

    public static void main(String[] args) {
       var ioc = SpringApplication.run(SpringBootStartDemo02Application.class, args);
//        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
//
////        Object bean = ioc.getBean("dataSource");
////        Object bean1 = ioc.getBean("dataSource");
//        Object bean = ioc.getBean(DruidDataSource.class);
//        Object bean1 = ioc.getBean(DruidDataSource.class);
//        System.out.println(bean1 == bean);
//        String[] beanNamesForType1 = ioc.getBeanNamesForType(Cat.class);
//        for (String s : beanNamesForType1) {
//            System.out.println(s);
//        }


//
//        String[] beanNamesForType = ioc.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }

        User user = ioc.getBean(User.class);
        System.out.println(user);

        Random random = new Random();
        int row = random.nextInt(1000000);
        System.out.println(row);
    }

}
