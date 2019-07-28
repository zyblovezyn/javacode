package com.java12.streampackage.p18;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: StreamTest18Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/28 0028 12:15
 */
public class StreamTest18Test {

    Stream<Integer> stream;

    @Before
    public void initData() {
        stream = Stream.iterate(1, x -> x + 1).limit(6);
    }

    @Test
    public void streamTest() {
     /*   Assert.assertEquals(stream.count(),6);
        stream.close();*/

        IntSummaryStatistics intSummaryStatistics = stream.filter(x -> x > 2).mapToInt(x -> x * 2).skip(2).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getCount());

        System.out.println(stream);
        System.out.println(intSummaryStatistics);
    }

    @Test
    public void streamTest2() {
        System.out.println(stream);
        Stream<Integer> stream1 = stream.filter(x -> x > 2);
        System.out.println(stream1);
        Stream<Integer> stream3=stream1.distinct();
        System.out.println(stream3);
    }

    @Test
    public void streamTest3(){
        List<String> list=Arrays.asList("hello","world","hello world");
        list.stream().map(x->x.substring(0,1).toUpperCase()+x.substring(1))
                .forEach(System.out::println);
    }

    @Test
    public void streamTest4(){
        IntStream.iterate(0,x->(x+1)%2).limit(6).distinct().forEach(System.out::println);
    }
}