package com.mail.concurrent.example.singleton;

import com.mail.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 单例对象--饿汉模式
 */
@Slf4j
@ThreadSafe
public class SingletonExample6 {

    private SingletonExample6() {

    }

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
