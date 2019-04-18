package concurrent.productAndconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {
    //共享缓存区
    private BlockingQueue<Data> queue;

    private volatile boolean isRunning = true;

    private static AtomicInteger count = new AtomicInteger();

    private static Random r = new Random();

    public Consumer(BlockingQueue<Data> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(r.nextInt(1000));
                Data data = this.queue.take();
                System.out.println("消费：" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
