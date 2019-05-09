package com.mail.concurrent.productAndconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider implements Runnable {
    //共享缓存区
    private BlockingQueue<Data> queue;

    private volatile boolean isRunning = true;

    private static AtomicInteger count = new AtomicInteger();

    private static Random r = new Random();

    public Provider(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(r.nextInt(1000));
                int id = count.incrementAndGet();

                Data data = new Data(id, "数据" + id);
                data.setId(id);
                data.setName("数据" + id);
                System.out.println("生产：" + data);
                if (!this.queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("数据提交到缓冲区失败...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
