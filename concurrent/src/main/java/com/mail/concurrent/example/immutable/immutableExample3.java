package com.mail.concurrent.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.mail.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@ThreadSafe
public class immutableExample3 {


    //private final static ImmutableList list=ImmutableList.of(1,2,3);
    private final static List<Integer> list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Object, Object> map=
            ImmutableMap.builder().put(1,2).put(3,4).build();
    public static void main(String[] args) {
//        set.add(4)
        //map.put(3,4);
        System.out.println(map.get(1));
    }

}
