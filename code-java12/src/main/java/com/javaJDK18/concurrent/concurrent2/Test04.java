public class MyThread extends Thread{
	private int count=5;
	@Override
	public void run(){
		super.run();
		while(count>0){
			// 1.取得原有i值 2.计算i-1 3.对i进行赋值
			count--;
			System.out.println("由 "+this.currentThread().getName()+" 计算，count="+count);
		}
	}
}
public class Run{
	public static void main(String[] args){
		MyThread myThread=new MyThread();
		Thread a=new Thread(myThread,"A");
		Thread b=new Thread(myThread,"B");
		Thread c=new Thread(myThread,"C");
		Thread d=new Thread(myThread,"D");
		Thread e=new Thread(myThread,"E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}
