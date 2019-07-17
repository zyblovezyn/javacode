package com.java12.collections.queue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zyb
 * @title: ArrayBlockingQueueTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/17 0017 21:42
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> list=Arrays.asList("a","b","c");
        ArrayBlockingQueue linkedQueue=new ArrayBlockingQueue<>(4,false,list);
        linkedQueue.offer("d");
        Object obj=linkedQueue.take();
        linkedQueue.put("11111111");
        linkedQueue.put("22222222");
        linkedQueue.put("333333333");
    }
}
