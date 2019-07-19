public class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		HasSelfPrivateNum numRef=new HasSelfPrivateNum();
		ThreadA a=new ThreadA(numRef);
		a.start();
		ThreadB b=new ThreadB(numRef);
		b.start();
	}
}

public class HasSelfPrivateNum{
	//private int num=0; 此时就是线程安全的
	/*synchronized*/public void addI(String usename){
		try{
			int num=0;
			if(usename.equals("a")){
				num=100;
				System.out.println("a set over!");
				Thread.sleep(1000);
			}else{
				num=200;
				System.out.println("b set over");
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class ThreadA extnds Thread{
	private HasSelfPrivateNum numRef;
	public ThreadA(HasSelfPrivateNum numRef){
		super();
		this.numRef=numRef;
	}
	@Override
		public void run(){
			super.run();
			numRef.addI("a");
	}
}
public class ThreadB extnds Thread{
	private HasSelfPrivateNum numRef;
	public ThreadA(HasSelfPrivateNum numRef){
		super();
		this.numRef=numRef;
	}
	@Override
		public void run(){
			super.run();
			numRef.addI("b");
	}
}
