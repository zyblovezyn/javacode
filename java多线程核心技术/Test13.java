public class Run
{

	private static Timer timer=new Timer();//new Timer(true) 传入true设置为守护进程
	static public class MyTask extends TimerTask{
		@Override
		public void run(){
			System.out.println("运行了!时间为:"+new Date());
	}

	public static void main(String[] args) 
	{
		try{
		System.out.println("Hello World!");
		MyTask task=new MyTask();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString="2014-02-01 13:12:12";
		Date dateRef=sdf.parse(dateString);
		System.out.println("字符串时间:"+dateRef.toLocalString()+"当前时间:"+new Date().toLocalString());
		timer.schedule(task,dateRef);
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
}
