package concurrent.productAndconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class UseLinkedBlockingQueue {
    //是一个阻塞的线程安全的队列 底层用链表实现
    //如果没有指定大小 默认为Integer.MAX_VALUE

    public static void main(String[] args) {
        try {
            BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);

            //add时超过链表容量会直接报错
            queue.add("1");
            queue.add("2");
            queue.add("3");


            //put 时超过链表容量会阻塞一直等待空闲，以加入元素
            queue.put("1");
            ;
            queue.put("2");
            queue.put("3");

            //offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false。

            /*
                从队列中取出并移除头元素的方法有：poll，remove，take。
                 poll: 若队列为空，返回null。

                 remove:若队列为空，抛出NoSuchElementException异常。

                 take:若队列为空，发生阻塞，等待有元素。
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
