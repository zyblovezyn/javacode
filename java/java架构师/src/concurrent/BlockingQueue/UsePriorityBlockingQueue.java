
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class UsePriorityBlockingQueue {

    public static void main(String[] args) {
        PriorityBlockingQueue<Task> queue=new PriorityBlockingQueue<>();
        Task t1=new Task();
        t1.setId(3);
        t1.setName("任务1");

        Task t2=new Task();
        t2.setId(6);
        t2.setName("任务2");

        Task t3=new Task();
        t3.setId(1);
        t3.setName("任务3");

        queue.add(t1);queue.add(t2);queue.add(t3);

        for(Iterator iterator=queue.iterator();iterator.hasNext();){
            Task task=(Task)iterator.next();
            System.out.println(task.getName());
        }

        try {
            System.out.println(queue.take().getName().toString());
            System.out.println(queue.take().getName());
            System.out.println(queue.take().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
