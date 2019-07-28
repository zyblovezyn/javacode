package com.java12.streampackage.p21;

import com.java12.streampackage.p19.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: StreamP21Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/28 0028 21:28
 */
public class StreamP21Test {

    List<Student> students;

    @Before
    public void setData() {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        students = Arrays.asList(student1,
                student2, student3, student4);
    }

    @Test
    public void test1() {
        //根据名字进行分组
        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(x -> x.getName()));
        System.out.println(map);

    }

    @Test
    public void test2() {
        //根据分数进行分组
        Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(x -> x.getScore()));
        System.out.println(map);

    }

    @Test
    public void test3() {
        //根据名字进行分组 分数相加
      /*  Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(x -> x.getScore()));
        System.out.println(map);*/

        Map<String, Double> map = students.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(map);

    }

    /**
     * 分区  只会有两组
     */
    @Test
    public void test4() {
        //根据名字进行分组 分数相加
      /*  Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(x -> x.getScore()));
        System.out.println(map);*/
        Map<Boolean, List<Student>> map = students.stream()
                .collect(Collectors.partitioningBy(x -> x.getScore() > 20));
        System.out.println(map);
        System.out.println();
        map.get(true).forEach(System.out::println);
    }
}