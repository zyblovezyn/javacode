package concurrent.listadd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ListAdd2 {

    private volatile static List list = new ArrayList();

    public void add() {
        list.add("bjsxt");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        final ListAdd2 list1 = new ListAdd2();
        //final Object lock = new Object();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        list1.add();
                        System.out.println("当前线程：" + Thread.currentThread().getName());
                        Thread.sleep(500);
                        if (list1.size() == 4) {
                            // System.out.println("已经发出通知");
                            ///   lock.notify();
                            //  }
                            countDownLatch.countDown();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //synchronized (lock) {
                if (list1.size() != 5) {
                    try {
                        //             lock.wait();//程序在等着
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---------" + list1.size() + "=5 种植");
                    throw new RuntimeException();
                    //  }
                }

            }
        }, "t2");
        t2.start();
        t1.start();
    }

}
