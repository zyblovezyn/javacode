package com.mail.GeneticsAndCollection.setAndMap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/*
    set集合的特点:
        无序
        不重复 元素唯一
        没有索引
 */
public class HashSetDemo {
    public static void main(String[] args) {

        //创建集合
        Set<String> set=new HashSet<>();

        //添加元素
        set.add("hello");
        set.add("world");
        System.out.println(set.add("java"));

        //遍历集合 数组遍历 iterator遍历 增强遍历

        //method(set);
        //iteratordemo(set);

        for (String s:set){
            System.out.println(s);
        }

    }

    private static void iteratordemo(Set<String> set) {
        Iterator<String> iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private static void method(Set<String> set) {
        Object[] objs=set.toArray();
        for(Object item:objs){
            System.out.println(item);
        }
    }
}

