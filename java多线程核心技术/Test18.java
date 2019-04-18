public class Run
{
	public static class MyTask extends TimerTask{
		@Override
		public void run(){
			System.out.println("运行了，时间为:"+new Date());
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		MyTask task=new MyTask();
		Timer timer=new Timer();
		System.out.println("当前时间:"+new Date().toLocalString());
		timer.schedule(task,7000);//以当前时间为参考，延迟7000ms后执行
		timer.schedule(task,7000,10*1000);//以当前时间为参考，延迟7s后，每个10秒执行一次本任务
	}
}
