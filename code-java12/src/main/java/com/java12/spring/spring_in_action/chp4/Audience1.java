package com.java12.spring.spring_in_action.chp4;

import org.aspectj.lang.annotation.*;

/**
 * @author zyb
 * @title: Audience1
 * @projectName code-java12
 * @description: 观看演出的切面 在Audience之上做了优化
 * @date 2019/8/10 0010 10:10
 */
//@Aspect
public class Audience1 {

    /**
     * 定义命名的切点，使用@Pointct注解定义切点
     */
    @Pointcut("execution(** com.java12.spring.spring_in_action.chp4.Performance.perfoem(..))")
    public void perform(){}

    /**
     * 表演之前
     */
    @Before("perform()")
    public void silenceCellPhones(){
        System.out.println("silence cell phones");
    }
    /**
     * 表演之前
     */
    @Before("perform()")
    public void takeSeats(){
        System.out.println("taking a seats");
    }

    /**
     * 表演之后
     */
    @AfterReturning("perform()")
    public void appleuse(){
        System.out.println("clap clap clap");
    }

    /**
     * 表演失败之后
     */
    @AfterThrowing("perform()")
    public void demandRefund(){
        System.out.println("deamnding a refund");
    }
}
