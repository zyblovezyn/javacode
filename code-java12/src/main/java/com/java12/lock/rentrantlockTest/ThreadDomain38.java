package com.java12.lock.rentrantlockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @title: ThreadDomain38
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/7 000722:13
 */
public class ThreadDomain38 {
    private Lock lock = new ReentrantLock();

    public void testMethod()
    {
        try
        {
            lock.lock();
            for (int i = 0; i < 10; i++)
            {
                System.out.println("ThreadName = " + Thread.currentThread().getName() +
                        ", i  = " + i);
            }
        }
        finally
        {
            lock.unlock();
        }
    }

}

class MyThread38 extends Thread
{
    private ThreadDomain38 td;

    public MyThread38(ThreadDomain38 td)
    {
        this.td = td;
    }

    public void run()
    {
        td.testMethod();
    }
}
class test{
    public static void main(String[] args)
    {
        ThreadDomain38 td = new ThreadDomain38();
        MyThread38 mt0 = new MyThread38(td);
        MyThread38 mt1 = new MyThread38(td);
        MyThread38 mt2 = new MyThread38(td);
        mt0.setName("mt0");
        mt1.setName("mt1");
        mt2.setName("mt2");
        mt0.start();
        mt1.start();
        mt2.start();
    }
}
