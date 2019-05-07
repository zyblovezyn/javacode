package concurrent.myObject;

import concurrent.test01.MyThread;

public class MyObject {


    public synchronized void m1() {
        try {
            System.out.println(Thread.currentThread().getName());
            ;
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void m2() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final MyObject mp = new MyObject();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mp.m1();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mp.m2();
            }
        }, "t2");

        t1.start();
        t2.start();
    }

}
