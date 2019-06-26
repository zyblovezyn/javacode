package com.atguigu.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.atguigu.gmall.service.OrderService;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDubbo
public class GmallConsumerApplication {

     public static void main(String[] args) throws IOException {

       /* System.out.println("Hello World!");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        context.start();
        OrderService orderService = context.getBean(OrderService.class); // 获取远程服务代理
        orderService.initOrder("0101"); // 执行远程方法
        //System.out.println( hello ); // 显示调用结果
        System.in.read();*/
         SpringApplication.run(GmallConsumerApplication.class,args);
         System.out.println("消费者启动成功！！！！！！！！！！！！！！！！！！！！！！！");
    }
}
