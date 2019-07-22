package com.javaJDK18.concurrent.concurrent2;

public class MyRunnable implements Runnable{
	@Override
	public void run(){
		System.out.println("运行中！");
	}
}

class Run1{
	public static void main(String[] args){
		Runnable runnable=new MyRunnable();
		Thread thread=new Thread(runnable);
		thread.start();
		System.out.println("运行结束");
	}
}
