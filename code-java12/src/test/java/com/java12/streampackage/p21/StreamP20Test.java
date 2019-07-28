package com.java12.streampackage.p21;

import com.java12.streampackage.p19.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: StreamP20Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/28 0028 21:11
 */
public class StreamP20Test {

    @Test
    public void test1() {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu"
                , "zhaoliu");
        list1.stream().flatMap(x -> list2.stream()
                .map(y -> x + " " + y))
                .forEach(System.out::println);

    }


}