package com.java12.HeadFirst.factory.simplefactory;

public class SimpleFactory {
    //实现统一管理，专业化管理 有执行标准
    public Car getCar(String name) {
        Car car;
        switch (name) {
            case "benz":
                car = new Benz();
                break;
            case "audi":
                car = new Audi();
                break;
            case "bmw":
                car = new Bmw();
                break;
            default:
                car = null;
                break;
        }
        return car;
    }
}
