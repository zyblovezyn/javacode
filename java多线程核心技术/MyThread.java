public class MyThread extends Thread {
	@Override public void run() {
	super.run();
	System.out.println("MyThread");
	}
}


public class Run{
	public static void main(String[] args){
		MyThread mythread=new MyThread();
		mythread.start();
		System.out.println("运行结束");
	}

}

 
