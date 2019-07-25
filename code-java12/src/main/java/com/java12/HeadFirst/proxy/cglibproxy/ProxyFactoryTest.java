package com.java12.HeadFirst.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

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
public class ProxyFactoryTest implements org.springframework.cglib.proxy.MethodInterceptor {
  /*  //维护目标对象
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
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务.......................");
        Object retValue = method.invoke(target, objects);
        System.out.println("结束事务.......................");
        return retValue;
    }*/

    private Object target;

    public ProxyFactoryTest(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        //工具类
        Enhancer enhancer = new Enhancer();

        //设置父类
        enhancer.setSuperclass(target.getClass());

        //设置回调函数
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("start transaction");
        Object ret = method.invoke(target, objects);
        System.out.println("end transaction");
        return ret;
    }
}
