package com.java12.HeadFirst.factory.abstractfactory;

import com.java12.HeadFirst.factory.func.Factory;
import com.java12.HeadFirst.factory.simplefactory.Benz;
import com.java12.HeadFirst.factory.simplefactory.Car;

/**
 * @author zyb
 * @title: AudiFactory
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/16 0016 21:29
 */
public class BenzFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
