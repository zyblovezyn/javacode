package com.mail.concurrent.connThreadLocal;

import java.util.Vector;

public class InnerSingleton {

    private static class Singleton {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return Singleton.singleton;
    }
}
