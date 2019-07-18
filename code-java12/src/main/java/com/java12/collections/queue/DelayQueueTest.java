package com.java12.collections.queue;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author zyb
 * @title: DelayQueueTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/18 0018 20:39
 */
public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {


       /* DelayQueue<DelaydElement> delayQueue=new DelayQueue<>();

        producer(delayQueue);

        consumer(delayQueue);

        while (true){
            TimeUnit.HOURS.sleep(1);
        }*/
    }

    private static void producer(final DelayQueue<DelaydElement> delayQueue) {
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DelaydElement element = new DelaydElement(1000, "test");
                delayQueue.offer(element);
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("delayQueue size:" + delayQueue.size());
            }
        }).start();
    }

    private static void consumer(final DelayQueue<DelaydElement> delayQueue) {
        new Thread(() -> {
            while (true) {
                DelaydElement element = null;
                try {
                    element = delayQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "--------" + element);
            }
        }).start();
    }

}

class DelaydElement implements Delayed {
    private final long delay; //延迟时间
    private final long expire; //到期时间
    private final String msg; //数据
    private final long now; //创建时间

    public DelaydElement(long delay, String msg) {
        this.delay = delay;
        this.msg = msg;
        this.expire = System.currentTimeMillis() + delay;
        now = System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "DelaydElement{" +
                "delay=" + delay +
                ", expire=" + expire +
                ", msg='" + msg + '\'' +
                ", now=" + now +
                '}';
    }
}
