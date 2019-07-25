package com.java12.HeadFirst.proxy.cglibproxy;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author zyb
 * @title: CglibProxy
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/15 0015 21:09
 */
public class CglibProxy {
    public static void main(String[] args) {
/*        // 目标对象
        UserDao target = new UserDao();

        // 代理对象
        UserDao proxy = (UserDao) new ProxyFactoryTest(target).getProxyInstance();

        // 执行代理方法
        proxy.save();*/

        UserDao target=new UserDao();
        UserDao proxy=(UserDao)new ProxyFactoryTest(target).getProxyInstance();
        proxy.save();
    }
}

/**
 * 目标对象 没有实现任何接口
 */
class UserDao {
    public void save() {
        System.out.println("-------已经保存数据-----------");
    }
}

