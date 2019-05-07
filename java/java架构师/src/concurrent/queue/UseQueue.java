package concurrent.queue;

import java.util.concurrent.*;

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
        //有界阻塞
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);
        try {
            arrayBlockingQueue.offer("a", 2, TimeUnit.SECONDS);
            arrayBlockingQueue.add("b");
            arrayBlockingQueue.add("c");
            arrayBlockingQueue.add("d");
            arrayBlockingQueue.add("e");
            System.out.println(arrayBlockingQueue.offer("f", 2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------");

        SynchronousQueue<String> sq = new SynchronousQueue<>();
        //sq.add("cdfcd"); 不允许加元素

        /*阻塞的线程安全的队列
          LinkedBlockingQueue构造的时候若没有指定大小，
          则默认大小为Integer.MAX_VALUE，当然也可以在构造函数的参数中指定大小。
          LinkedBlockingQueue不接受null。

             添加元素的方法有三个：add,put,offer,
             且这三个元素都是向队列尾部添加元素的意思。
             add方法在添加元素的时候，若超出了度列的长度会直接抛出异常
             put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素。
             offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false。

              从队列中取出并移除头元素的方法有：poll，remove，take。
                poll: 若队列为空，返回null。
                remove:若队列为空，抛出NoSuchElementException异常。
                take:若队列为空，发生阻塞，等待有元素。
         */
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(3);
        /*
        linkedBlockingQueue.add("a");
        linkedBlockingQueue.add("b");
        linkedBlockingQueue.add("c");
        linkedBlockingQueue.add("d");
        */

        /*
        try {
            linkedBlockingQueue.put("a");
            linkedBlockingQueue.put("b");
            linkedBlockingQueue.put("c");
            linkedBlockingQueue.put("d");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        System.out.println(linkedBlockingQueue.offer("1"));
        System.out.println(linkedBlockingQueue.offer("2"));
        System.out.println(linkedBlockingQueue.offer("3"));
        System.out.println(linkedBlockingQueue.offer("4"));


    }

}
