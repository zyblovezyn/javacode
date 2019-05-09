package com.mail.concurrent.example.synchronizedExample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class syncExample1 {

    //synchronized  修饰代码块
    public void test1(int j){
        synchronized (this){
            for (int i=0;i<10;i++){
                log.info("test1 {} - {}",j,i);
            }
        }
    }

    public synchronized void test2(int j){
        for (int i=0;i<10;i++){
            log.info("test {} - {}",j,i);
        }

    }

    public static void main(String[] args) {
        syncExample1 syncExample1=new syncExample1();
        syncExample1 syncExample2=new syncExample1();
        ExecutorService executorService=Executors.newCachedThreadPool();

        executorService.execute(()->{
            syncExample1.test2(1);
        });
        executorService.execute(()->{
            syncExample2.test2(2);
        });
        executorService.shutdown();

    }
}
