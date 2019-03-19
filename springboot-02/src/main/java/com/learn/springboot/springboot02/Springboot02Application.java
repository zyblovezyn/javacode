package com.learn.springboot.springboot02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //加上注解
public class Springboot02Application {

    public static void main(String[] args) {
        //启动springboot程序 启动springboot容器 启动内嵌tomcat
        SpringApplication.run(Springboot02Application.class, args);
    }

}
