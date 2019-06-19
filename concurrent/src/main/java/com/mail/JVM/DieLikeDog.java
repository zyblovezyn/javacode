package com.mail.JVM;

public class DieLikeDog {

    public static void main(String[] args) {
        System.out.println("hello");

        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());

        String str1="abc";
        String str2="abc";
        System.out.println(str1==str2);
        String str3=new String("abc");
        String str4=new String("abc");

        System.out.println(str3==str4);
        System.out.println(str3.equals(str4));

    }
}
