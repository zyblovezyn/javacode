//懒汉模式实现单例模式
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

//静态内置对象 实现单例模式
public class MyObject{
	//内部类方式
	private static class MyObjectHandler	{
		private static MyObject myObject=new MyObject();
	}
	private MyObject(){
	}
	public static MyObject getInstance(){
		return MyObjectHandler.myObject;
}

//序列化反序列化的单例模式
public class MyObject implements Serializable{
	private static final long serialVersionUID=888L;
	//内部类方式
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

//使用static代码块实现单例模式
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

