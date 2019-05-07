package concurrent.UseCountDownLetch;

import java.util.concurrent.CountDownLatch;

public class UseCountDownLetch {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入线程1" + "等待其他线程处理完成...");
                    countDownLatch.await();
                    System.out.println("t1线程继续执行...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t2进行初始化操作...");
                    Thread.sleep(3 * 1000);
                    countDownLatch.countDown();
                    System.out.println("t2初始化完毕...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t3进行初始化操作...");
                    Thread.sleep(3 * 1000);
                    countDownLatch.countDown();
                    System.out.println("t3初始化完毕...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }
}
