package com.java12.streampackage.p19;

import java.util.stream.Stream;

/**
 * @author zyb
 * @title: StreamTest18 代码在测试类中
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/28 0028 12:10
 */
public class StreamTest19 {


    Stream<Integer> stream=Stream.iterate(1,item->item+2).limit(6);
    public void streamTest(){
            stream.forEach(System.out::println);
    }

}
