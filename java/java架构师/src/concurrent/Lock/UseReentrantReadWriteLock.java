package concurrent.Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UseReentrantReadWriteLock {


    // 用在读多写少的情况

    private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock=readWriteLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock=readWriteLock.writeLock();

    public void read(){
        try{
            readLock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + "进入...");
            Thread.sleep(3*1000);
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + "退出...");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            readLock.unlock();
        }
    }
    public void write(){
        try{
            writeLock.lock();
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + "进入...");
            Thread.sleep(3*1000);
            System.out.println("当前线程 " + Thread.currentThread().getName()
                    + "退出...");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        UseReentrantReadWriteLock useReentrantReadWriteLock=new UseReentrantReadWriteLock();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                useReentrantReadWriteLock.read();
            }
        });
        t1.setName("t1");

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                useReentrantReadWriteLock.read();
            }
        });
        t2.setName("t2");

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                useReentrantReadWriteLock.write();
            }
        });
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
