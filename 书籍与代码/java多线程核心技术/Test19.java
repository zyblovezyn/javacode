//����ģʽʵ�ֵ���ģʽ
public class MyObject
{
	 private volatile static MyObject myObject;
	 public MyObject(){
	  }
	  public static MyObject getInstance(){
		  try{
		  if(myObject==null){		  
			synchronized(MyObject.class){
				if(myObject==null){
					myObject=new MyObject();
				}
			}
		  }
		  }catch(InterruptedException e){
			  e.printStackTrace();
		  }
	  }
}

//��̬���ö��� ʵ�ֵ���ģʽ
public class MyObject{
	//�ڲ��෽ʽ
	private static class MyObjectHandler	{
		private static MyObject myObject=new MyObject();
	}
	private MyObject(){
	}
	public static MyObject getInstance(){
		return MyObjectHandler.myObject;
}

//���л������л��ĵ���ģʽ
public class MyObject implements Serializable{
	private static final long serialVersionUID=888L;
	//�ڲ��෽ʽ
	private static class MyObjectHandler	{
		private static MyObject myObject=new MyObject();
	}
	private MyObject(){
	}
	public static MyObject getInstance(){
		return MyObjectHandler.myObject;
	}
	protected Object readResolve() throws ObjectStramException{
		return MyObjectHandler.myObject;
	}
}

//ʹ��static�����ʵ�ֵ���ģʽ
public class MyObject{
	private static MyObject instance=null;
	private MyObject(){
	}
	static{
		instance=new MyObject();
	}
	public static MyObject getInstance(){
		return instance;
	}
}

