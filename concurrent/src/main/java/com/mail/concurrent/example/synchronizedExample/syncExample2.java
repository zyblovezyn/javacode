package com.mail.concurrent.example.synchronizedExample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class syncExample2 {

    //synchronized  修饰类
    public static void test1(int j){
        synchronized (syncExample2.class){
            for (int i=0;i<10;i++){
                log.info("test1 {} - {}",j,i);
            }
        }
    }

    // 修饰静态方法
    public static synchronized void test2(int j){
        for (int i=0;i<10;i++){
            log.info("test {} - {}",j,i);
        }

    }

    public static void main(String[] args) {
        syncExample2 syncExample1=new syncExample2();
        syncExample2 syncExample2=new syncExample2();
        ExecutorService executorService=Executors.newCachedThreadPool();

        executorService.execute(()->{
            syncExample1.test1(1);
        });
        executorService.execute(()->{
            syncExample2.test1(2);
        });
        executorService.shutdown();

    }
}
