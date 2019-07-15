package com.java12.HeadFirst.proxy.staticproxy;

/**
 * @author zyb
 * @title: StaticProxy  静态代理
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/15 0015 20:23
 */
public class StaticProxy {
    public static void main(String[] args) {

        //目标对象
        UserDao target=new UserDao();

        //代理对象，把目标对象传给代理对象，建立代理关系
        UserDaoProxy proxy=new UserDaoProxy(target);

        proxy.save(); //执行的是代理的方法

    }
}

/**
 * 接口
 */
interface IUserDao{
    void save();
}
/**
 * 接口实现
 * 目标对象
 */
class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("-------已经保存数据-----------");
    }
}

/**
 * 代理对象,静态代理
 */
class UserDaoProxy implements IUserDao{

    //接收保存目标对象
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务.........");
        target.save();
        System.out.println("提交事务.........");
    }
}
