package com.mail.concurrent.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockExample6 {
    public static void main(String[] args) {

        ReentrantLock reentrantLock=new ReentrantLock();
        Condition condition=reentrantLock.newCondition();

        new Thread(()->{
            try{
                reentrantLock.lock();
                log.info("wait signal");
                condition.await();
            }catch (Exception e){
                e.printStackTrace();
            }
            log.info("get start");
            reentrantLock.unlock();
        }).start();

        new Thread(()->{
            try{
                reentrantLock.lock();
                log.info("get lock");
            }catch (Exception e){
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send signal~");
            reentrantLock.unlock();
        }).start();

    }
}
