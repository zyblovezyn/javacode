package com.java12.HeadFirst.factory.abstractfactory;

import com.java12.HeadFirst.factory.simplefactory.Car;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zyb
 * @title: DefaultFactory
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/16 0016 21:46
 */
public class DefaultFactory extends AbstractFactory {

    private AudiFactory defaultFactory=new AudiFactory();
    @Override
    protected Car getCar() {
        return defaultFactory.getCar();
    }
}
