public class Run
{

	private static Timer timer=new Timer();//new Timer(true) ����true����Ϊ�ػ�����
	static public class MyTask1 extends TimerTask{
		@Override
		public void run(){
			System.out.println("MyTask1������!ʱ��Ϊ:"+new Date());
	}

	static public class MyTask2 extends TimerTask{
		@Override
		public void run(){
			System.out.println("MyTask2������!ʱ��Ϊ:"+new Date());
	}
	public static void main(String[] args) 
	{
		try{
		System.out.println("Hello World!");
		MyTask1 task=new MyTask1();
		MyTask2 task=new MyTask2();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString="2014-02-01 13:12:12";
		Date dateRef=sdf.parse(dateString);

		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString1="2014-02-01 14:12:12";
		Date dateRef1=sdf1.parse(dateString1);

		System.out.println("�ַ���ʱ��:"+dateRef.toLocalString()+"��ǰʱ��:"+new Date().toLocalString());
				System.out.println("�ַ���ʱ��:"+dateRef1.toLocalString()+"��ǰʱ��:"+new Date().toLocalString());
		timer.schedule(task1,dateRef);
		timer.schedule(task2,dateRef1);
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
}
