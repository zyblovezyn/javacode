package com.mail.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample3 {

    private static CyclicBarrier barrier = new CyclicBarrier(5,()->{
        log.info("{}","callback is running");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException, TimeoutException {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);

        // 加上try catch 到时见抛出异常 但是不影响主流程的执行
        try {
            barrier.await(2000, TimeUnit.MILLISECONDS);
        }catch (Exception e){
            log.error("{}",e);
        }
        log.info("{} continue", threadNum);
    }
}
