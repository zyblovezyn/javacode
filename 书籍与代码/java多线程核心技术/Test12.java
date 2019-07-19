public class Run
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		MyService service=new MyService();
		ThreadA a=new ThreadA(service);
		a.setName("A");
		a.start()
		ThreadB b=new ThreadB(service);
		b.setName("B");
		b.start();
		Thread.sleep(3000);
		service.singalAll_A();
	}
}

public class MyService{
	private Lock lock=new ReentrantLock();
	public Condition conditionA=lock.newCondition();
	public Condition conditionB=lock.newCondition();
	public void awaitA(){
		try{
			lock.lock();
			System.out.println("begin awaitA时间为"+System.curentTimeMillis()+Thread.currentThread().getName());
			conditionA.await();
			System.out.println("end awaitA时间为...");
		}catch(InterruptedException e){
			e.printStackTrace();
		}final{
			lock.unlock();
		}
	}
	public void awaitB(){
		try{
			lock.lock();
			System.out.println("begin awaitB时间为"+System.curentTimeMillis()+Thread.currentThread().getName());
			conditionB.await();
		}catch(InterruptedException e){
			e.printStackTrace();
		}final{
			lock.unlock();
		}
	}
	public void singalAll_A(){
		try{
			lock.lock();
			System.out.println("begin singalAll_A时间为"+System.curentTimeMillis()+Thread.currentThread().getName());
			conditionA.signalAll();
		}catch(InterruptedException e){
			e.printStackTrace();
		}final{
			lock.unlock();
		}
	}
	public void singalAll_B(){
		try{
			lock.lock();
			System.out.println("begin singalAll_A时间为"+System.curentTimeMillis()+Thread.currentThread().getName());
			conditionB.signalAll();
		}catch(InterruptedException e){
			e.printStackTrace();
		}final{
			lock.unlock();
		}
	}
}

public class ThreadA extends Thread{
	private MyService service;
	public ThreadA(MyService service){
		super();
		this.service=service;
	}
	@Override
	public void run(){
		service.awaitA();
	}
}
public class ThreadB extends Thread{
	private MyService service;
	public ThreadB(MyService service){
		super();
		this.service=service;
	}
	@Override
	public void run(){
		service.awaitB();
	}
}