package com.java12.streampackage.p22;

import com.java12.streampackage.p19.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: StreamP22Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/29 0029 22:28
 */
public class StreamP22Test {

    private List<Student> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);

        list = Arrays.asList(student1, student2, student3, student4);
    }

    @Test
    public void test1() {
        //流转化成集合
        List<Student> list1 = list.stream().collect(Collectors.toList());
        list1.forEach(System.out::println);

        //求集合数量
        System.out.println("count: "+list1.stream().collect(Collectors.counting()));
        System.out.println("count: "+list1.stream().count());
    }
}