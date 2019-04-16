package concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class UseQueue {


    public static void main(String[] args) {

        // 高性能无阻塞
        ConcurrentLinkedQueue<String> q1 = new ConcurrentLinkedQueue<String>();
        q1.offer("a");
        q1.offer("b");
        q1.offer("c");
        q1.offer("d");

        q1.add("e");
        System.out.println(q1.poll());//从头部取出元素 从队列中删除
        System.out.println(q1.size());//4
        System.out.println(q1.peek());//取出不删除
        System.out.println(q1.size());//4


        System.out.println("-------------------------------");

        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(5);
        try {
            arrayBlockingQueue.offer("a",2,TimeUnit.SECONDS);
            arrayBlockingQueue.add("b");
            arrayBlockingQueue.add("c");
            arrayBlockingQueue.add("d");
            arrayBlockingQueue.add("e");
            System.out.println(arrayBlockingQueue.offer("f",2,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------");

        SynchronousQueue<String> sq=new SynchronousQueue<>();
        //sq.add("cdfcd"); 不允许加元素
    }

}
