package com.java12.spring.spring_in_action.chp4;

import org.springframework.stereotype.Service;

/**
 * @author zyb
 * @title: PerformanceImpl
 * @projectName code-java12
 * @description:        @Component ：标准一个普通的spring Bean类。
 *                      @Repository：标注一个DAO组件类。
 *                      @Service：标注一个业务逻辑组件类。
 *                      @Controller：标注一个控制器组件类。
 * @date 2019/8/10 0010 10:23
 */
@Service
public class PerformanceImpl implements Performance {
    @Override
    public void perform() {
        System.out.println("start play....");
    }

    @Override
    public void performCount(Integer count) {
        System.out.println(" sing song ");
    }
}
