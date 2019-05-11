package com.mail.concurrent.example.commonUnsafe;

import com.mail.concurrent.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class ArrayListExample1 {
    //请求总数
    public static int clientTotal = 5000;
    // 同时并发的线程数
    public static int threadTotal = 50;

    // 线程不安全
    public static StringBuffer stringBuilder = new StringBuffer();

    private static List<Integer> list=new ArrayList<Integer>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(count);
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
        executorService.shutdown();
        log.info("{}",list.size());
    }

    public static void add(int count) {
        try {
            list.add(count);
        } catch (Exception e) {
            log.error("{}", e.toString());
        }
    }
}
