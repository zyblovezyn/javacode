import java.lang.Thread;
public class Countoperate extends Thread{
	public Countoperate(){
		System.out.println("Countoperate---begin");
		System.out.println("Thread.currentThread().getName()="+
				Thread.currentThread.getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("Countoperate end!");
	}
	@Override
	public void run(){
		System.out.println("run---begin");
		System.out.println("Thread.currentThread().getName()="+
				Thread.currentThread().getName());
		System.out.println("this.getName()= "+this.getName());
		System.out.println("run end!");
	}
}
public class Run{
	public static void main(String[] args){
		Countoperate c=new Countoperate();
		Thread t1=new Thread(c);
		t1.setName("A");
		t1.start();
	}
}
