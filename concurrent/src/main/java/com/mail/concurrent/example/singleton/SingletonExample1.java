package com.mail.concurrent.example.singleton;

import com.mail.concurrent.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 单例对象--懒汉模式
 */
@Slf4j
@NotThreadSafe
public class SingletonExample1 {
    private SingletonExample1(){

    }

    private static SingletonExample1 instance=null;

    public static SingletonExample1 getInstance(){
        if(instance==null){
            instance=new SingletonExample1();
        }
        return instance;
    }
}
