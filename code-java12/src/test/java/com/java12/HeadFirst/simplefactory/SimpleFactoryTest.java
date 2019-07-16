package com.java12.HeadFirst.simplefactory;

import com.java12.HeadFirst.factory.simplefactory.SimpleFactory;
import org.junit.Test;

/**
 * @author zyb
 * @title: SimpleFactoryTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/16 0016 21:01
 */
public class SimpleFactoryTest {
    SimpleFactory simpleFactory=new SimpleFactory();
    @Test
    public void getCar() {
       simpleFactory.getCar("benz").getName().equals("BENZ");
    }
}