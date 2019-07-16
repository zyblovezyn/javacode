package com.java12.HeadFirst.factory.abstractfactory;

/**
 * @author zyb
 * @title: Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/16 0016 21:47
 */
public class Test {
    public static void main(String[] args) {
        DefaultFactory factory = new DefaultFactory();
        System.out.println(factory.getCar().getName());
        System.out.println(factory.getCar("bmw").getName());
    }
}
