package com.mail.socketIO.socketio_01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerExectorPool {

    private ExecutorService executorService;

    public HandlerExectorPool(int maxPoolSize, int queueSize) {
        this.executorService = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize)
        );
    }

    public void execute(Runnable task) {
        this.executorService.execute(task);
    }
}
