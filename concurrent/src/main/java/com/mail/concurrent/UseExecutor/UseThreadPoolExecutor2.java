package com.mail.concurrent.UseExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UseThreadPoolExecutor2 implements Runnable {
    private static AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        try {
            int temp = count.incrementAndGet();
            System.out.println(temp);
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue =
                new LinkedBlockingQueue<>();
        //new ArrayBlockingQueue<>(10);

        ExecutorService executorService = new ThreadPoolExecutor(
                5,
                10,//此参数已无效
                120L,
                TimeUnit.SECONDS,
                queue
        );
        for (int i = 0; i < 20; i++) {
            executorService.execute(new UseThreadPoolExecutor2());
        }
        try {
            Thread.sleep(1000);
            System.out.println("queue size:" + queue.size());
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
