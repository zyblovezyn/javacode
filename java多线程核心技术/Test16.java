publci class Run
{

	publci static class MyTask extends TimerTask{
		@Override
		public void run(){
			Thread.sleep(5000);//执行延误
			System.out.println("运行了! 时间为:"+new Date());
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		try{
			MaTask task=new MyTask();
			SimpleDataFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateStr="2015-01-01 12:12:12";
			Date date=sdf.parse(dateStr);
			Timer timer=new Timer();
			timer.schedule(task,date,4000);
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
}
