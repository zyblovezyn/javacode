public class MyThread implements Runnable{
	@Override
	public void run(){
		try{
			for (int i=0;i<10;i++){
				System.out.println("运行中！");
			}
	}catch(InterruptedException e){
		e.printStackTrace();
	}
}

public class Test{
	public static void main(String[] args){
		Runnable runnale=new MyThread();
		Thread thread=new Thread(runnale);
		thread.start();
		System.out.println("运行结束");
	}
}


