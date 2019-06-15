package com.mail.GeneticsAndCollection.chapter1;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToListTest {
    public static void main(String[] args) {
        List<Integer> ints=Arrays.asList(new Integer[]{1,2,3});

        List<String> words=Arrays.asList(new String[]{"hello","world"});

        Arrays.asList(1,2,3);

        Arrays.asList("hello","world");



        Collections.addAll(ints,1,2);
        Collections.addAll(ints,new Integer[]{3,4});
        assert ints.toString().equals("[1,2,3,4]");

    }
}
