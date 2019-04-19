package concurrent.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UseCondition {

    private ReentrantLock lock=new ReentrantLock();

    private Condition condition=lock.newCondition();
    public void method1(){
        try{
            lock.lock();
            System.out.println("当前线程"+Thread.currentThread().getName()
                    +"进入method1");
            Thread.sleep(1000);
            condition.await();
            System.out.println("当前线程"+Thread.currentThread().getName()
                    +"退出method1");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void method2(){
        try{
            lock.lock();
            System.out.println("当前线程"+Thread.currentThread().getName()
                    +"进入method2");
            Thread.sleep(2000);
            System.out.println("当前线程"+Thread.currentThread().getName()
                    +"退出method2");
            Thread.sleep(2000);
            condition.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final UseCondition ur= new UseCondition();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                ur.method1();
            }
        },"t1");

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                ur.method2();
            }
        },"t1");
        t1.start();t2.start();
    }

}
