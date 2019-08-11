package com.java12.spring.spring_in_action.chp4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author zyb
 * @title: Audience1
 * @projectName code-java12
 * @description: 观看演出的切面 在Audience1之上做了优化
 * @date 2019/8/10 0010 10:10
 */
@Aspect
public class Audience2 {

    /**
     * 定义命名的切点，使用@Pointct注解定义切点
     */
    @Pointcut("execution(** com.java12.spring.spring_in_action.chp4.Performance.perform(..))")
    public void perform(){}

    /**
     * 使用环绕通知方法
     */
    @Around("perform()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try {
            System.out.println("silence cell phone");
            System.out.println("taking a seats");
            jp.proceed();
            System.out.println("clap clap clap");
        }catch (Throwable e){
            System.out.println("Demanding a refund");
        }
    }
}
