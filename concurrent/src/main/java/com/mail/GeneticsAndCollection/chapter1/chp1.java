package com.mail.GeneticsAndCollection.chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class chp1 {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        int s = 0;
        for (int m : ints) {
            s += m;
        }
        System.out.println(s);

        String s1 = "hello";
        String s2 = s1;
        String s3 = new String("world");

        Set set = new HashSet();
        set.add(s1);
        set.add(s2);
        set.add(s3);

        System.out.println(set.size());
    }
}
