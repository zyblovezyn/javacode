package com.mail.concurrent.UseCountDownLetch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Usesemaphore {


    public static void main(String[] args) {


        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 只能5个线程同时访问
        final Semaphore semaphore = new Semaphore(5);

        // 模拟20个客户端
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {

                        //获得许可
                        semaphore.acquire();
                        System.out.println("Accessing:" + NO);
                        //模拟业务逻辑
                        Thread.sleep((long) (Math.random() * 10000));

                        // 访问完毕释放
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
