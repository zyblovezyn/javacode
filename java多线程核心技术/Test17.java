publci class Run
{
	publci static class MyTaskA extends TimerTask{
		@Override
		public void run(){
			System.out.println("A������! ʱ��Ϊ:"+new Date());
			this.cancel(); //����������ȡ����Ӱ����������
		}
	}
	publci static class MyTaskA extends TimerTask{
		@Override
		public void run(){
			System.out.println("B������! ʱ��Ϊ:"+new Date());
			this.cancel(); 
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		try{
			MaTask taskA=new MyTask();
			MaTask taskB=new MyTask();

			SimpleDataFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateStr="2015-01-01 12:12:12";
			Date date=sdf.parse(dateStr);
			Timer timer=new Timer();
			timer.schedule(taskA,date,4000);
			timer.schedule(taskB,date,4000);
			//timer.cancel() ���ȫ������
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
}
