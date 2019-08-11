package com.java12.spring.spring_in_action.chp4.config;

import com.java12.spring.spring_in_action.chp4.Audience1;
import com.java12.spring.spring_in_action.chp4.Audience2;
import com.java12.spring.spring_in_action.chp4.TrackCounter;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zyb
 * @title: ConcertCOnfig
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/10 0010 10:19
 */
@Configuration
/**
 * 启用AspectJ注解
 */
@EnableAspectJAutoProxy
@ComponentScan("com.java12.spring.spring_in_action.chp4")
public class ConcertConfig {
    /**
     * 声明Audience1 bean
     * @return
     */
    @Bean
    public Audience1 audience1(){
        return new Audience1();
    }
    @Bean
    public Audience2 audience2(){
        return new Audience2();
    }

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }
}
