class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		try{
			MyThread thread=new MyThread();
			thread.setDaemon(true);
			thread.start();
			Thread.sleep(5000);
			System.out.println("�뿪thread ���ڴ�ӡ ֹͣ");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
	}
}

public class MyThread extends Thread{
	private int i=0;
	@Override
		public void run(){
		try{
			while(true){
				i++;
				System.out.println("i="+(i));
				Thread.sleep(1000);
			}
		}catch(InteruptedException e){
			e.printStackTrace();
		}
	}
}
