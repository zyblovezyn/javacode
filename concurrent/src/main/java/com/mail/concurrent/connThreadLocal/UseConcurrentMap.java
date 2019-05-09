package com.mail.concurrent.connThreadLocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UseConcurrentMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("k1", "v1");
        concurrentHashMap.put("k2", "v2");
        concurrentHashMap.put("k3", "v3");
        concurrentHashMap.putIfAbsent("k3", "vvvvv");


        for (Map.Entry<String, String> me : concurrentHashMap.entrySet()) {
            System.out.println("key:" + me.getKey() + " value:" + me.getValue());
        }
    }
}
