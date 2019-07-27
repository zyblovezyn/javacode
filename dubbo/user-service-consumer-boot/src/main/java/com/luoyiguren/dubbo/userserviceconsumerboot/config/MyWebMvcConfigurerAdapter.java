package com.luoyiguren.dubbo.userserviceconsumerboot.config;

import com.luoyiguren.dubbo.userserviceconsumerboot.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @author zyb
 * @title: MyWebMvcConfigurerAdapter
 * @projectName user-service-consumer-boot
 * @description: TODO
 * @date 2019/7/28 0028 0:19
 */

@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }
}
