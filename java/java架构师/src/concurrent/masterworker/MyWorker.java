package concurrent.masterworker;

public class MyWorker extends Worker {
    Object handle(Task task) {
        Object output = null;
        try {
            //表示处理task的耗时,可以是数据的加工，也可以是操作数据库...
            Thread.sleep(500);
            output = task.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }
}
