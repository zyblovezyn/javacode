package com.mail.concurrent.example.singleton;

import com.mail.concurrent.annotation.NotThreadSafe;
import com.mail.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 单例对象--饿汉模式
 */
@Slf4j
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2(){

    }

    private static SingletonExample2 instance=new SingletonExample2();

    public static SingletonExample2 getInstance(){
        return instance;
    }
}
