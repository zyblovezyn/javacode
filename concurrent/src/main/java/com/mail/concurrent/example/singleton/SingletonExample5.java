package com.mail.concurrent.example.singleton;

import com.mail.concurrent.annotation.NotThreadSafe;
import com.mail.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 单例对象--volatile+双重同步锁单例模式
 */
@Slf4j
@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5() {

    }

    private volatile static SingletonExample5 instance =null;

    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {   // 同步锁
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
