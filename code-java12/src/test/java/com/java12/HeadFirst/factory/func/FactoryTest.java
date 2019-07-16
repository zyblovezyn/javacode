package com.java12.HeadFirst.factory.func;

import org.junit.Test;

/**
 * @author zyb
 * @title: FactoryTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/16 0016 21:32
 */
public class FactoryTest {

    @Test
    public void getCar() {
        //工厂方法模式
        // 各个产品的生产商，都用于各自的工厂
        // 生产工艺不同
        // 缺点增加了代码的复杂度
        Factory factory=new BmwFactory();
        System.out.println(factory.getCar().getName());
    }
}