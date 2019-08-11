package com.java12.spring.spring_in_action.chp4;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author zyb
 * @title: Audience
 * @projectName code-java12
 * @description: 观看演出的切面
 * @date 2019/8/10 0010 9:57
 */
//@Aspect
public class Audience {
    /**
     * 表演之前
     */
    @Before("execution (** com.java12.spring.spring_in_action.chp4.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("Silence cell Phones");
    }

    /**
     * 表演之前
     */
    @Before("execution(** com.java12.spring.spring_in_action.chp4.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Tacking Seats");
    }

    /**
     * 表演之后
     */
    @AfterReturning("execution(** com.java12.spring.spring_in_action.chp4.Performance.perform(..))")
    public void applause(){
        System.out.println("CLAP CLAP CLAP");
    }

    /**
     * 表演失败之后
     */
    @AfterThrowing("execution(** com.java12.spring.spring_in_action.chp4.Performance.perform(..))")
    public void demandfund(){
        System.out.println("Demanding a refund");
    }
}
