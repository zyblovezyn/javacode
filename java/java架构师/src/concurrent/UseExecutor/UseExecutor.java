package concurrent.UseExecutor;

import java.util.concurrent.*;

public class UseExecutor {
    public static void main(String[] args) {
        Temp temp=new Temp();
        ExecutorService pool = Executors.newScheduledThreadPool(1);

        // 1秒钟之后每隔3秒执行一次
        ScheduledFuture<?> scheduledFuture=((ScheduledExecutorService) pool).scheduleWithFixedDelay(temp,1,3,TimeUnit.SECONDS);
    }
}

class Temp extends Thread{
    public void run(){
        System.out.println("run");
    }
}