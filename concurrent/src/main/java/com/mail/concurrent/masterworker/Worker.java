package com.mail.concurrent.masterworker;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Worker implements Runnable {

    private ConcurrentLinkedQueue<Task> workQueue;
    private ConcurrentHashMap<String, Object> resultMap;


    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public void setWorkerQueue(ConcurrentLinkedQueue<Task> workQueue) {
        this.workQueue = workQueue;
    }


    @Override
    public void run() {
        while (true) {
            Task task = this.workQueue.poll();
            if (null == task) {
                break;
            }
            //真正的去做业务处理
            Object result = handle(task);
            resultMap.put(Integer.toString(task.getId()), result);
        }
    }

    // 让子类继承并事项handle方法
    abstract Object handle(Task task);

   /* private Object handle(Task task) {
        Object output=null;
        try {
            //表示处理task的耗时,可以是数据的加工，也可以是操作数据库...
            Thread.sleep(500);
            output=task.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }*/
}
