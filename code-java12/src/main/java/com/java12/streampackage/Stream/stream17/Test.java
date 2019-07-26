package com.java12.streampackage.Stream.stream17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @title: Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/13 001317:55
 */
public class Test {
    public static void main(String[] args) {
        Stream<String> stream=Stream.of("hello","world","hello world");
        String str=stream.collect(Collectors.joining());
        System.out.println(str);

        System.out.println("-------------------------");

        List<String> list=Arrays.asList("hello","world","helloworld");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
    }
}
