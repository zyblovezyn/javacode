package com.mail.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLetchExample2 {
    private final static int threadCount=200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService=
                Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch=new CountDownLatch(threadCount);

        for(int i=0;i<threadCount;i++){
            final int threadNum=i;
            executorService.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
                finally {
                    countDownLatch.countDown();
                }
            });

        }
        //await等待CountDownLetch里面的计数器捡到0才允许执行后面的代码
        // 支持给定时间的等待
        countDownLatch.await(10,TimeUnit.MILLISECONDS);
        log.info("finished");
        executorService.shutdown();
    }
    private static void test(int threadNum) throws InterruptedException {
        log.info("{}",threadNum);
        Thread.sleep(1);
    }
}
