public class Run
{
	public static class MyTask extends TimerTask{
		@Override
		public void run(){
			System.out.println("�����ˣ�ʱ��Ϊ:"+new Date());
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		MyTask task=new MyTask();
		Timer timer=new Timer();
		System.out.println("��ǰʱ��:"+new Date().toLocalString());
		timer.schedule(task,7000);//�Ե�ǰʱ��Ϊ�ο����ӳ�7000ms��ִ��
		timer.schedule(task,7000,10*1000);//�Ե�ǰʱ��Ϊ�ο����ӳ�7s��ÿ��10��ִ��һ�α�����
	}
}
