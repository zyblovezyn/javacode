package com.mail.GeneticsAndCollection.setAndMap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
    HashSet的add
    如果hash值不一样添加元素
    hash值一样，则比较较地址值或者equals方法进行比较
    比较结果一样，则是重复 不添加

 */
public class HashSetDemo2 {
    public static void main(String[] args) {

        HashSet<Student> hs=new HashSet<Student>();
        Student s=new Student("zhangsan",18);
        Student s1=new Student("lisi",19);
        Student s3=new Student("lisi",19);
        hs.add(s);
        hs.add(s1);
        hs.add(s3);

        for(Student student:hs){
            System.out.println(student);
        }


    }
}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("------------------");
        Student s=(Student)obj;
        if(this.age!=s.age)
            return false;
        if(this.name!=s.name)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}


