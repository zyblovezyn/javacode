package com.mail.data_struct;

import java.util.HashSet;
import java.util.Set;

public class uniqueemail {
    public static void main(String[] args) {
        String[] strs = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(strs));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> strings = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        boolean flagplus = false;
        for (String email : emails) {
            for (char c : email.toCharArray()) {
                if (!flag) {
                    if (c == '.') {
                        continue;
                    }
                    if (c == '+') {
                        flagplus = true;
                        continue;
                    }
                }
                if (c == '@') {
                    flagplus = false;
                    flag = true;
                }
                if (flagplus) {
                    continue;
                }
                sb.append(c);
            }
            strings.add(sb.toString());
            sb.delete(0, sb.length());
            flag = false;
            flagplus = false;
        }
        return strings.size();
    }
}
