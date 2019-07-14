package com.luoyiguren.dubbo.userserviceproviderboot;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@EnableDubbo  //开启基于注解的dubbo
//@ImportResource(locations = "classpath:provider.xml")
@SpringBootApplication
 public class UserServiceProviderBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderBootApplication.class, args);
    }
}
