package com.java12.HeadFirst.factory.abstractfactory;

import com.java12.HeadFirst.factory.simplefactory.Audi;
import com.java12.HeadFirst.factory.simplefactory.Benz;
import com.java12.HeadFirst.factory.simplefactory.Bmw;
import com.java12.HeadFirst.factory.simplefactory.Car;

/**
 * @author zyb
 * @title: AbstractFactory
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/16 0016 21:39
 */
public abstract class AbstractFactory {
    protected abstract Car getCar();

    public Car getCar(String name) {
        Car car;
        switch (name) {
            case "benz":
                car = new BenzFactory().getCar();
                break;
            case "audi":
                car = new AudiFactory().getCar();
                break;
            case "bmw":
                car = new BmwFactory().getCar();
                break;
            default:
                car = null;
                break;
        }
        return car;
    }
}
