package com.mail.concurrent.example.lock;

import com.mail.concurrent.annotation.NotThreadSafe;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@NotThreadSafe
public class LockExample2 {

    private final Map<String, Data> map = new TreeMap<>();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public static void main(String[] args) {
        String s = ";;";

        char[] chs = s.toCharArray();
        Stack stack = new Stack();
        List<Character> temp = new ArrayList<>();
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stack.push(chs[i]);
            } else if (chs[i] == ')') {
                stack.pop();
            }
            temp.add(chs[i]);
            if (stack.empty()) {
                for(int j=0;j<temp.size();j++){
                    builder.append(temp.get(j));
                }
                temp.clear();
            }
        }
        builder.toString();

        System.out.println();
        List<String> list = new ArrayList<>();
        if (list.size() > 1) {
            list.remove(0);
            list.remove(list.size() - 1);
        }
    }


    public Data get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys() {
        readLock.lock();
        try {
            return map.keySet();
        } finally {
            readLock.unlock();
        }
    }

    public void put(String key, Data value) {
        writeLock.lock();
        try {
            map.put(key, value);
        } finally {
            readLock.unlock();
        }
    }

    class Data {

    }
}
