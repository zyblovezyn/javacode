public class Run
{

	private static Timer timer=new Timer();//new Timer(true) ����true����Ϊ�ػ�����
	static public class MyTask extends TimerTask{
		@Override
		public void run(){
			System.out.println("������!ʱ��Ϊ:"+new Date());
	}

	public static void main(String[] args) 
	{
		try{
		System.out.println("Hello World!");
		MyTask task=new MyTask();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString="2014-02-01 13:12:12";
		Date dateRef=sdf.parse(dateString);
		System.out.println("�ַ���ʱ��:"+dateRef.toLocalString()+"��ǰʱ��:"+new Date().toLocalString());
		timer.schedule(task,dateRef);
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
}
