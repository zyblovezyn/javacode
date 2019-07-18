package com.java12.collections.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zyb
 * @title: LinkedBlockQueueTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/18 0018 22:59
 */
public class LinkedBlockQueueTest {
    public static void main(String[] args) throws InterruptedException {


        // 代码几句话源码调半天
        LinkedBlockingQueue<String> queue=new LinkedBlockingQueue(2);

        queue.add("hello");

        queue.add("world");

        queue.put("yes");
    }
}
