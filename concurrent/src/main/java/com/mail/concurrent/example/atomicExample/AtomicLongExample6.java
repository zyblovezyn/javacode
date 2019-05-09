package com.mail.concurrent.example.atomicExample;

import com.mail.concurrent.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@ThreadSafe
@Slf4j
public class AtomicLongExample6 {
    //请求总数
    public static int clientTotal = 5000;
    // 同时并发的线程数
    public static int threadTotal = 50;
    private static AtomicBoolean isHappend = new AtomicBoolean(false);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
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
        log.info("isHappend:{}", isHappend.get());
    }

    private static void test() {
        if (isHappend.compareAndSet(false, true)) {
            log.info("execute");
        }
    }
}
