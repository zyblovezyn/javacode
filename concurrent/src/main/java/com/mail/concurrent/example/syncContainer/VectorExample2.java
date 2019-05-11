package com.mail.concurrent.example.syncContainer;

import com.mail.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

@Slf4j
@ThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };


            thread1.start();
            thread2.start();
        }
    }

    public static void add(int count) {
        try {
            vector.add(count);
        } catch (Exception e) {
            log.error("{}", e.toString());
        }
    }
}
