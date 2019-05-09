package com.mail.concurrent.example.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class immutableExample2 {

    private final static Map<Integer,Integer> map=Maps.newHashMap();
    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        map.put(1,3);

        log.info("{}",map.get(1));
    }

}
