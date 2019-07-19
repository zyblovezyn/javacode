class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");

		try{
			ThreadA a=new ThreadA();
			a.setPriority(Thread.NORM_PRIORITY-3);
			a.start();
			ThreadB b=new ThreadB();
			b.setPriority(Thread.NORM_PRIORITY+3);
			b.start();
			a.stop();
			b.stop();
			System.out.println("a="+a.getCount());
			System.out.println("a="+a.getCount());
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class ThreadA extends Thread{
	private int count=0;

	public int getCount(){
		return count;
	}

	@Override
		public void run(){
		while(true){
			count++;
		}
	}
}


public class ThreadB extends Thread{
	private int count=0;

	public int getCount(){
		return count;
	}

	@Override
		public void run(){
		while(true){
			count++;
		}
	}
}