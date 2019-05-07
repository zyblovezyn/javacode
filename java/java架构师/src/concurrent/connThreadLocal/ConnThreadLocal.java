package concurrent.connThreadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ConnThreadLocal {

    public static ThreadLocal<String> th = new ThreadLocal<String>();

    public void setTh(String value) {
        th.set(value);
    }

    public void getTh() {
        System.out.println(Thread.currentThread().getName() + ":" + this.th.get());
    }

    public static void main(String[] args) {
        final ConnThreadLocal ct = new ConnThreadLocal();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ct.setTh("张三");
                ct.getTh();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    ct.getTh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");

        t1.start();
        t2.start();

        Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
        System.out.println(1 << 30);
        System.out.println(Integer.MAX_VALUE >> 1);
        System.out.println(Integer.MAX_VALUE / 2);

    }
}
