package com.java12.spring.spring_in_action.chp2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyb
 * @title: CDPlayerConfig
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/4 0004 22:17
 */
@Configuration
/**
 * value和basePackages都可以指定需要扫描的包 basePackages={"包1","包2"}可以指定多个包
 */
//@ComponentScan(value = "com.java12.spring.spring_in_action.componentTest")
//@ComponentScan(basePackages = "com.java12.spring.spring_in_action.componentTest")
@ComponentScan
 public class CDPlayerConfig {
}
