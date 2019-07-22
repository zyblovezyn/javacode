package com.java12.collections.queue;

import java.io.Serializable;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author zyb
 * @title: PriorityBlockingQueueTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/22 0022 20:41
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        Comparator<Test> comparator = new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                } else if (o1.getAge() < o2.getAge()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        PriorityBlockingQueue<Test> priorityBlockingQueue = new PriorityBlockingQueue<>(11,comparator);
        priorityBlockingQueue.add(new Test("zhang", 12));
        priorityBlockingQueue.add(new Test("wang", 15));

        priorityBlockingQueue.add(new Test("li", 10));

        priorityBlockingQueue.add(new Test("zhao", 11));

    }
}

class Test implements Serializable {
    private int age;
    private String name;

    public Test(String name,int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
