package com.mail.concurrent.BlockingQueue;

import java.util.concurrent.*;

public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        Productor p1 = new Productor(queue);
        Productor p2 = new Productor(queue);
        Productor p3 = new Productor(queue);

        Cosumer c1 = new Cosumer(queue);
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(p1);
        service.execute(p2);
        service.execute(p3);
        service.execute(c1);

        try {
            Thread.sleep(10 * 1000);
            p1.wait();
            p2.wait();
            p3.wait();
            Thread.sleep(2000);
            service.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
