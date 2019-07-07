package com.java12.lock.rentrantlockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @title: ThreadDomain40
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/7 000722:31
 */
public class ThreadDomain40 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println("await时间为：" + System.currentTimeMillis());
            condition.await();
            System.out.println("await等待结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal时间为：" + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}

class MyThread40 extends Thread {
    private ThreadDomain40 td;

    public MyThread40(ThreadDomain40 td) {
        this.td = td;
    }

    public void run() {
        td.await();
    }
}
class test1{
    public static void main(String[] args) throws Exception
    {
        ThreadDomain40 td = new ThreadDomain40();
        MyThread40 mt = new MyThread40(td);
        mt.start();
        Thread.sleep(10000);
        td.signal();
    }
}
