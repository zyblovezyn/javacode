
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        //内存缓冲区
        BlockingQueue<Data> queue = new LinkedBlockingQueue<>(10);

        //生产者
        Provider p1 = new Provider(queue);
        Provider p2 = new Provider(queue);
        Provider p3 = new Provider(queue);

        //消费者
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        //创建执行线程，这是一个线程池可以创建无穷大的线程
        ExecutorService cachePool = Executors.newCachedThreadPool();
        cachePool.execute(p1);
        cachePool.execute(p2);
        cachePool.execute(p3);

        cachePool.execute(c1);
        cachePool.execute(c2);
        cachePool.execute(c3);
        try {
            Thread.sleep(3000);
            ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
