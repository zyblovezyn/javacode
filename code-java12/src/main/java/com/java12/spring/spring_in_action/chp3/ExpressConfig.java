package com.java12.spring.spring_in_action.chp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author zyb
 * @title: ExpressConfig
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/8 0008 23:06
 */
@Configuration
@PropertySource("classpath:app.properties")
public class ExpressConfig {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc disc(){
        return  new BlankDisc(env.getProperty("disc.title","hello"),
                env.getProperty("disc.artist","world"));
    }

    /**
     * 获取整数值
     * @return
     */
    @Bean
    public BlankDisc disc1(){
        return  new BlankDisc(env.getProperty("disc.title","hello"),
                env.getProperty("disc.artist","world"),
                env.getProperty("connectionCount",Integer.class,30));
    }

    /**
     * 如果配置文件中没有值 则为null,
     * 可以设置为必须配置数据getRequiredProperty
     * @return
     */
    @Bean
    public BlankDisc disc2(){
        return  new BlankDisc(env.getRequiredProperty("disc.title"),
                env.getRequiredProperty("disc.artist"),
                env.getRequiredProperty("connectionCount",Integer.class));
    }
}
