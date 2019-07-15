package com.java12.collections.queue;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * @author zyb
 * @title: ConcurrentLinkedQueueTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/15 0015 22:14
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {

        List<String> list=Arrays.asList("a","b","c");
        ConcurrentLinkedQueue<String> linkedQueue=new ConcurrentLinkedQueue<>(list);
        linkedQueue.offer("d");

        System.out.println(Reflection.getCallerClass());

    }


}
