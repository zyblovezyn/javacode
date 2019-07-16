package com.java12.HeadFirst.factory.func;

import com.java12.HeadFirst.factory.simplefactory.Car;

/**
 * @author zyb
 * @title: Factory
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/16 0016 21:28
 */
public interface Factory {
    //符合上路标准
    // 符合尾气排放标准
    //电子设备安全系数
    //安全气囊 轮胎等等标准
    Car getCar();
}
