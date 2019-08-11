package com.java12.spring.spring_in_action.chp4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zyb
 * @title: test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/10 0010 10:39
 */
@Component
public class Test1 {
    @Autowired
    Performance performance;

    public void perform(){
        performance.perform();
    }

    public void performCount(Integer count){
        performance.performCount(count);
    }
}
