package com.java12.streampackage.p17;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author zyb
 * @title: Test
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/22 0022 21:46
 */
public class Test {
    public static void main(String[] args) {
     /*   Stream<List<Integer>> stream=Stream.of(Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5,6));
        stream.flatMap(list->list.stream()).map(x->x*x).forEach(System.out::println);*/


  /*      System.out.println("----------------------");
        Stream<String> stringStream=Stream.generate(UUID.randomUUID()::toString);
        System.out.println(stringStream.findFirst().get());
        stringStream.findFirst().ifPresent(System.out::println);*/

        System.out.println("---------");

        //iterate 生成无限流 所以加limit加以限制
        System.out.println(Stream.iterate(1, x -> x + 1).limit(7).filter(x -> x > 2).skip(2).limit(2).reduce((x, y) -> x + y).get());


    }
}
