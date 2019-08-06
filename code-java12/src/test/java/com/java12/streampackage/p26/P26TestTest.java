package com.java12.streampackage.p26;

import com.java12.streampackage.p19.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import org.springframework.util.comparator.Comparators;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: P26TestTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/6 0006 22:11
 */
public class P26TestTest {


    private List<Student> list = new ArrayList<>();
    private List<String> stringList = Arrays.asList("nihao", "hello", "world", "welcome");

    @Before
    public void setUp() throws Exception {

        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);
        Student student5 = new Student("zhaoliu", 90);

        list = Arrays.asList(student1, student2, student3, student4, student5);
    }

    @Test
    public void Test() {

        Collections.sort(stringList);
        System.out.println(stringList);
    }

    @Test
    public void Test1() {
        Collections.sort(stringList, (x, y) -> y.length() - x.length());
        System.out.println(stringList);
    }

    @Test
    public void Test2() {
        Collections.sort(stringList,
                Comparator.comparingInt(String::length).reversed());
         System.out.println(stringList);
    }

    @Test
    public void Test3() {
        Collections.sort(stringList,
                Comparator.comparingInt((String item)->item.length()).reversed());
        System.out.println(stringList);
     }
}