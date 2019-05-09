package com.mail.concurrent.example.singleton;

import com.mail.concurrent.annotation.NotThreadSafe;
import com.mail.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 单例对象--双重同步锁单例模式
 */
@Slf4j
@NotThreadSafe
public class SingletonExample4 {

    private SingletonExample4() {

    }

    private static SingletonExample4 instance =null;

    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample4.class) {   // 同步锁
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
