package concurrent.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UseMultiCondition {

    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public void m1() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + " 进入方法m1等待...");
            c1.await();
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + " m1继续执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m2() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + " 进入方法m2等待...");
            c1.await();
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + " m2继续执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m3() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + " 进入方法m3等待...");
            c2.await();
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + " m3继续执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m4() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + "唤醒...");
            c1.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m5() {
        try {
            lock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + "唤醒...");
            c2.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final UseMultiCondition useMultiCondition=new UseMultiCondition();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                useMultiCondition.m1();
            }
        },"t1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                useMultiCondition.m2();
            }
        },"t2");

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                useMultiCondition.m3();
            }
        },"t3");
        Thread t4=new Thread(new Runnable() {
            @Override
            public void run() {
                useMultiCondition.m4();
            }
        },"t4");

        Thread t5=new Thread(new Runnable() {
            @Override
            public void run() {
                useMultiCondition.m5();
            }
        },"t5");

        // 保证t1 t2 t3 限先执行
        t1.start();t2.start();t3.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t4.start();t5.start();
    }
}
