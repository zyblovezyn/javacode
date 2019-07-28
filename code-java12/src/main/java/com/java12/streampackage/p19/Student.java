package com.java12.streampackage.p19;

import java.io.Serializable;
import java.util.stream.Stream;

/**
 * @author zyb
 * @title: Student
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/28 0028 16:42
 */
public class Student implements Serializable {
    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
    }

    public Student(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}



