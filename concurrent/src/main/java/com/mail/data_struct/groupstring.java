package com.mail.data_struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupstring {
    public static void main(String[] args) {
        String[] strings = new String[]{"aa","bb","ab","ba"};
        System.out.println(numSpecialEquivGroups(strings));
    }

    public static int numSpecialEquivGroups(String[] A) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        int int1 = 0;
        int int2 = 0;
        for (String s : A) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    int1 = int1 + chars[i];
                } else {
                    int2 = int2 + chars[i];
                }
            }
            if (hashMap.containsKey(int1)) {
                hashMap.get(int1).add(int2);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(int2);
                hashMap.put(int1, list);
            }
            int1 = 0;
            int2 = 0;
        }
        int res = 0;
        for (Map.Entry<Integer, List<Integer>> map : hashMap.entrySet()) {
            res += map.getValue().stream().distinct().count();
        }
        return res;
    }
}
