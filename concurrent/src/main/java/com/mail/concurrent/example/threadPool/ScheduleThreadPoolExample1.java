package com.mail.concurrent.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ScheduleThreadPoolExample1 {

    public static void main(String[] args) {

        ScheduledExecutorService executorService=Executors.newScheduledThreadPool(5);


        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                log.warn("schedule run");
            }
        },3,TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.warn("schedule run1");
            }
        },1,3,TimeUnit.SECONDS);

       // executorService.shutdown();
    }
}
