package com.java12.streampackage.p25;

import com.java12.streampackage.p19.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: P25TestTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/4 0004 19:47
 */
public class P25TestTest {

    private List<Student> list = new ArrayList<>();

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
        // 找出分数最低的学生并把打印
        System.out.println(list.stream()
                .collect(minBy(Comparator.comparing(Student::getScore)))
                .get());

        System.out.println(list.stream().collect(maxBy(Comparator.comparing(Student::getScore)))
                .get());

        System.out.println(list.stream().collect(averagingInt(Student::getScore)));

        System.out.println(list.stream()
                .collect(summarizingInt(Student::getScore)).getSum());
    }


    @Test
    public void test1() {
        System.out.println(list.stream().map(x -> x.getName()).collect(joining()));
        System.out.println(list.stream().map(x -> x.getName()).collect(joining(",", "begin", "end")));

        Map<Integer, Map<String, List<Student>>> map = list.stream()
                .collect(groupingBy(Student::getScore, groupingBy(Student::getName)));

        for (Integer key : map.keySet()) {
            Map<String, List<Student>> map1 = map.get(key);
            for (String key1 : map1.keySet()) {
                System.out.println(map1.get(key1));
            }
        }

        Map<Boolean, List<Student>> booleanListMap = list.stream().collect(partitioningBy(x -> x.getScore() > 80));

        System.out.println(list.stream().collect(partitioningBy(x -> x.getScore() > 80, partitioningBy(y -> y.getScore() > 90))));
        System.out.println(booleanListMap);
    }

    @Test
    public void test2() {
       Map<Boolean,Long> map=
                list.stream()
                .collect(partitioningBy(x->x.getScore()>80,counting()));
        System.out.println(map);
    }
}