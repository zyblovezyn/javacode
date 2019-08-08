package com.java12.streampackage.p27;

import com.java12.streampackage.p19.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.comparator.Comparators;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: p27Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/7 0007 20:04
 */
public class p27Test {

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
    public void test() {
        stringList.sort(Comparator.comparingInt(String::length).reversed());

        stringList.sort(Comparator.comparingInt((String item) -> item.length()));
        stringList.stream().forEach(System.out::println);
    }

    @Test
    public void test1() {

        Collections
                .sort(stringList, Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        stringList.stream().forEach(System.out::println);
    }

    @Test
    public void test2() {
        Collections.sort(stringList,Comparator.comparingInt(String::length));
        stringList.stream().forEach(System.out::println);
    }

    @Test
    public void test3() {
       Collections.sort(stringList,Comparator.comparingInt(String::length).reversed()
       .thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));
        stringList.stream().forEach(System.out::println);
    }
}