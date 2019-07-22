package com.javaJDK18.concurrent.concurrent2;

import java.lang.Thread;
class Countoperate extends Thread{
	public Countoperate(){
		System.out.println("Countoperate---begin");
		System.out.println("Thread.currentThread().getName()="+
				Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("Countoperate end!");
	}
	@Override
	public void run(){
		System.out.println("run---begin");
		System.out.println("Thread.currentThread().getName()="+
				Thread.currentThread().getName());
		System.out.println("this.getName()= "+this.getName());
		System.out.println("run end!");
	}
}
public class Run2 {
	public static void main(String[] args){
		Countoperate c=new Countoperate();
		Thread t1=new Thread(c);
		t1.setName("A");
		t1.start();
	}
}
