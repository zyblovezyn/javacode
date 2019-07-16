package com.java12.HeadFirst.factory.func;

import com.java12.HeadFirst.factory.simplefactory.Audi;
import com.java12.HeadFirst.factory.simplefactory.Car;

/**
 * @author zyb
 * @title: AudiFactory
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/16 0016 21:29
 */
public class AudiFactory implements Factory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
