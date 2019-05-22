package com.mail.JDK.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class stramtest {

    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(list.stream().map(i->2*i).reduce(0,Integer::sum));
    }
}
