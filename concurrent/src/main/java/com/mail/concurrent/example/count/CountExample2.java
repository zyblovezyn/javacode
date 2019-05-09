package com.mail.concurrent.example.count;

import com.mail.concurrent.annotation.NotThreadSafe;
import com.mail.concurrent.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class CountExample2 {

    //请求总数
    public static int clientTotal = 5000;
    // 同时并发的线程数
    public static int threadTotal = 50;

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count:"+count);
    }

    public static void add() {
        count.incrementAndGet();
    }
}
