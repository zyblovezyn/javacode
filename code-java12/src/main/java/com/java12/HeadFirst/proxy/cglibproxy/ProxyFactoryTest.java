package com.java12.HeadFirst.proxy.cglibproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zyb
 * @title: Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/15 0015 21:41
 */


/**
 * Cglib 子类代理工厂
 * 对UserDao在内存中动态构建一个子类对象
 */
public class ProxyFactoryTest implements MethodInterceptor, Callback {
    //维护目标对象
    private Object target;

    public ProxyFactoryTest(Object target) {
        this.target = target;
    }

    // 给目标对象创建一个代理对象
    public Object getProxyInstance() {
        // 1. 工具类
        Enhancer enhancer = new Enhancer();
        // 2. 设置父类
        enhancer.setSuperclass(target.getClass());
        // 3. 设置回调函数
        //enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("开始事务......");

        // 执行目标方法
        Object returenValue = methodInvocation.getMethod().invoke(target, methodInvocation.getArguments());

        System.out.println("提交事务.....");
        return returenValue;

    }
}
