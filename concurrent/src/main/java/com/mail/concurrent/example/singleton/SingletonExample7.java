package com.mail.concurrent.example.singleton;

import com.mail.concurrent.annotation.Recomment;
import com.mail.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 枚举模式是最安全的
 */
@Slf4j
@ThreadSafe
@Recomment
public class SingletonExample7 {

    private SingletonExample7() {
    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private SingletonExample7 singleton;

        //JVM 保证只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }

    }
}
