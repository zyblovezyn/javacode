public class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		PublicVar numRef=new PublicVar();
		ThreadA a=new ThreadA(numRef);
		a.start();
		Thread.sleep(200);
		numRef.getValue();
	}
}

public class PublicVar{
	 public String username="A";
	 public String password="AA";
	 synchronized public void setValue(String username,String password){
		 try{
			 this.username=username;
			 Thread.sleep(5000);
			 this.password=password;
			System.out.println(" setValue method thread name=" + Thread. currentThread(). getName() + " username=" + username + " password=" + password);
		 }catch(InterruptedException e){
			 e.printStackTrace();
		 }
	 }
	 public void getValue(){
			System.out.println(" setValue method thread name=" + Thread. currentThread(). getName() + " username=" + username + " password=" + password);
	 }
 }

public class ThreadA extnds Thread{
	private PublicVar numRef;
	public ThreadA(PublicVar numRef){
		super();
		this.numRef=numRef;
	}
	@Override
		public void run(){
			super.run();
			numRef.setValue("B","BB");
	}
}
 
