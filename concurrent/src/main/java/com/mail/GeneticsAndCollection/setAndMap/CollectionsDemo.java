package com.mail.GeneticsAndCollection.setAndMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        // method();
        //method1();

        // method2();

        // method3();
        //  method4();
        // method5();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        Collections.swap(list,0,1);
        System.out.println(list);
    }

    private static void method5() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }

    private static void method4() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }

    private static void method3() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        Collections.reverse(list);

        System.out.println(list);
    }

    private static void method2() {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);

        Collections.fill(list, "android");
        System.out.println(list);
    }

    private static void method1() {
        List<String> src = new ArrayList<String>();

        // 注意目标列表的长度至少等于原列表的长度
        List<String> dest = new ArrayList<String>();
        src.add("hello");
        src.add("world");
        src.add("java");

        dest.add("");
        dest.add("");
        dest.add("");
        dest.add("");

        Collections.copy(dest, src);

        System.out.println(dest);
    }

    private static void method() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int index = Collections.binarySearch(list, 4);
        System.out.println(index);
    }
}
