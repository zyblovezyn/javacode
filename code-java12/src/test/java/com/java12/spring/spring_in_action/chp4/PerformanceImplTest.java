package com.java12.spring.spring_in_action.chp4;

import com.java12.spring.spring_in_action.chp4.config.ConcertConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: PerformanceImplTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/10 0010 10:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class PerformanceImplTest {

    @Autowired
    TrackCounter trackCounter;

    @Autowired
    Test1 performance;

    @Test
    public void perform() {
        performance.performCount(1);
        performance.performCount(1);
        performance.performCount(1);
        performance.performCount(2);
        performance.performCount(2);
        performance.performCount(2);
        performance.performCount(3);

        System.out.println(trackCounter.getPerformCount(1));
        System.out.println(trackCounter.getPerformCount(2));
        System.out.println(trackCounter.getPerformCount(3));
        System.out.println(trackCounter.getPerformCount(4));
    }

}