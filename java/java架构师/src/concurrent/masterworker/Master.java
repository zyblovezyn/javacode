package concurrent.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

    // 1 应该有一个承装任务的集合
    private ConcurrentLinkedQueue<Task> workerQueue=
            new ConcurrentLinkedQueue<>();

    // 2 使用普通的hashMap去承装所有的worker对象
    private HashMap<String,Thread> workers=new
            HashMap<>();

    // 3 使用一个容器承装每一个worker执行的结果集
    private ConcurrentHashMap<String,Object> result=new ConcurrentHashMap<>();

    // 4 构造方法
    public Master(Worker worker,int workerCount){
        //每一worker对象都需要master的引用
        //workerQueue用于任务的领取
        //result用于任务的提交
        worker.setWorkerQueue(this.workerQueue);
        worker.setResultMap(this.result);
        for(int i=0;i<workerCount;i++){
            // key表示每一个worker的名字 value表示线程执行对象
            workers.put("子节点"+Integer.toString(i),new Thread(worker));
        }
    }

    // 5提交方法

    public void submit(Task task){
        this.workerQueue.add(task);
    }

    // 6需要执行的方法 启动应用程序让所有的worker工作
    public void execute(){
        for (Map.Entry<String,Thread> me:workers.entrySet()){
            me.getValue().start();
        }
    }
    // 7判断线程是否执行完毕
    public boolean isComplete() {
        for(Map.Entry<String,Thread> me:workers.entrySet()){
            if(me.getValue().getState()!=Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }
    // 8返回结果集数据
    public Integer getResult() {
        Integer result=0;
        for(Map.Entry<String,Object> me:this.result.entrySet()){
            result+=Integer.parseInt(me.getValue().toString());
        }
        return result;
    }
}
