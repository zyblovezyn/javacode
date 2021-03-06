package com.java12.HeadFirst.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author zyb
 * @title: JdkProxy
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/15 0015 20:41
 */
public class JdkProxy {
    public static void main(String[] args) {
        //目标对象
        IUserDao target = new UserDao();

        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();

        //class 内存中动态生成的代理对象 $Proxy0
        System.out.println(proxy.getClass());

        proxy.save();

    }
}

class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开始事务");
                    Object ret = method.invoke(target, args);
                    System.out.println("结束事务");
                    return ret;
                });
    }
}

/*
 * 接口
 */

interface IUserDao {
    void save();
}


/**
 * 接口实现
 * 目标对象
 */

class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("-------已经保存数据-----------");
    }
}

