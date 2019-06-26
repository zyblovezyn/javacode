package com.atguigu.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@SpringBootApplication
@EnableDubbo //开启基于注解的dubbo功能
//@EnableHystrix //开启服务容错
public class GmallProviderApplication  {
    public static void main(String[] args) throws IOException {

        SpringApplication.run(GmallProviderApplication.class, args);

      /*  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        context.start();
        System.in.read(); // 按任意键退出*/

        System.out.println("生产者启动！！！！！！！！！！！！！！！！");
    }

}


