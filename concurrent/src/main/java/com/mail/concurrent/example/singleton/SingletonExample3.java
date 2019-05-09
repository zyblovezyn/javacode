package com.mail.concurrent.example.singleton;

import com.mail.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 单例对象--饿汉模式
 */
@Slf4j
@ThreadSafe
public class SingletonExample3 {

    private SingletonExample3(){

    }

    private static SingletonExample3 instance=new SingletonExample3();

    public static synchronized SingletonExample3 getInstance(){
        if(instance==null){
            instance=new SingletonExample3();
        }
        return instance;
    }
}
