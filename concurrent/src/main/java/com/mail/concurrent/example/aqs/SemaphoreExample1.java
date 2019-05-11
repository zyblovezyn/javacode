package com.mail.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class SemaphoreExample1 {
    private final static int threadCount=200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService=
                Executors.newCachedThreadPool();

        final Semaphore semaphore=new Semaphore(3);
        for(int i=0;i<threadCount;i++){
            final int threadNum=i;
            executorService.execute(()->{
                try {
                    semaphore.acquire(3);// 获取指定数目的许可
                    test(threadNum);
                    semaphore.release(3);// 释放指定数目许可
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
            });
        }
        log.info("finished");
        executorService.shutdown();
    }
    private static void test(int threadNum) throws InterruptedException {
        log.info("{}",threadNum);
        Thread.sleep(100);
    }
}
