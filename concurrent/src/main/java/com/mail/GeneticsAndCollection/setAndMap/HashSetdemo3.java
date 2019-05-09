package com.mail.GeneticsAndCollection.setAndMap;

import java.util.HashSet;
import java.util.Set;

//优化hashCode 与 equals 方法
public class HashSetdemo3 {

    public static void main(String[] args) {

        HashSet<Person> hs = new HashSet<Person>();

        Person p1 = new Person("zhangsan", 19);
        Person p2 = new Person("lisi", 20);
        Person p3 = new Person("lisi", 20);

        hs.add(p1);
        hs.add(p2);
        hs.add(p3);

        for (Person p : hs) {
            System.out.println(p);
        }
    }

}

class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

/*    @Override
    public boolean equals(Object obj) {
        System.out.println("-----------------------");

        if(this==obj)
            return true;

        if(this.getClass()!=obj.getClass())
            return false;

        Person person = (Person) obj;

        if (this.age != person.age)
            return false;
        if (!this.name.equals(person.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        *//**
         *
         * 优化
         *
         *
         *
         *
         *//*
        return age+name.hashCode();
    }*/


}
