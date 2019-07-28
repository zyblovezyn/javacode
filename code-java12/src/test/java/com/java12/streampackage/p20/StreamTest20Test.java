package com.java12.streampackage.p20;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: StreamTest20Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/28 0028 20:24
 */
public class StreamTest20Test {

    List<String> list = new ArrayList<>(5000000);

    @Before
    public void setUp() throws Exception {
       /* for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }*/
    }

    @Test
    public void testParallel() {
        long startTime = System.nanoTime();
        System.out.println(list.parallelStream().sorted().limit(1).count());
        long endTime = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
    }

    @Test
    public void testSerial() {
        long startTime = System.nanoTime();
        System.out.println(list.stream().sorted().limit(1).count());
        long endTime = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
    }

    @Test
    public void test1(){
        List<String> list=Arrays.asList("hello","world","hello world");
        list.stream().filter(x->x.length()==5).limit(1).forEach(x-> System.out.println(x.length()+" "+x));

        list.stream().mapToInt(x->x.length()).filter(x->x>5).findFirst().ifPresent(System.out::println);

        System.out.println("------------------");
        list.stream().mapToInt(x->x.length()).forEach(System.out::println);

        list.stream().mapToInt(x->x.length()).reduce((x,y)->x+y).ifPresent(System.out::println);
    }

    @Test
    public void test2(){
        List<String> list=Arrays.asList("hello welcome",
                "world hello","hello world hello",
                "hello welcome");
        // 找出所有单词 并且去除重复
        list.stream().map(x->x.split(" "))
                .flatMap(Arrays::stream).distinct()
                .forEach(System.out::println);

    }
}