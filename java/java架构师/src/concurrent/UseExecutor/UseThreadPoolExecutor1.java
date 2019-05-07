package concurrent.UseExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UseThreadPoolExecutor1 {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,      //corePoolSize
                2,  //MaxSize
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3), //有界队列
                //new ThreadPoolExecutor.DiscardOldestPolicy()//丢弃最老的任务，执行新的任务
                new MyRejected()
        );
        MyTask t1 = new MyTask(1, "任务1");
        MyTask t2 = new MyTask(2, "任务2");
        MyTask t3 = new MyTask(3, "任务3");
        MyTask t4 = new MyTask(4, "任务4");
        MyTask t5 = new MyTask(5, "任务5");
        MyTask t6 = new MyTask(6, "任务6");

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);

        pool.shutdown();

    }
}
