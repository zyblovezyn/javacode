package com.java12.spring.spring_in_action.chp4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyb
 * @title: TrackCOunter
 * @projectName code-java12
 * @description: 计算表演次数的切面
 * @date 2019/8/10 0010 11:45
 */

@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounter = new HashMap<>();

    @Pointcut(
            "execution(* com.java12.spring.spring_in_action.chp4.Performance.performCount(Integer)) "
                    + "&& args(count)"
    )
    /**
     * 切点 通知perform方法
     */
    public void performCount(Integer count) {
    }

    @Before("performCount(count)")
    public void countPerform(Integer count) {
        Integer currentCount = getPerformCount(count);
        trackCounter.put(count, currentCount + 1);
     }

    public Integer getPerformCount(Integer count) {
        return trackCounter.containsKey(count) ? trackCounter.get(count) : 0;
    }
}
