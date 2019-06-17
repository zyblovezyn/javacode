package com.mail.JVM;

public class DieLikeDog {

    public static void main(String[] args) {
        System.out.println("hello");

        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());

    }
}
