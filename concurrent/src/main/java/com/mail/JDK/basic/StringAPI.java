package com.mail.JDK.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class StringAPI {

    private static final String str = "abcdef";

    public static void main(String[] args) {
        //stringContructor();
        System.out.println(str.charAt(0));
        System.out.println(str.codePointAt(0));
        System.out.println(str.codePointBefore(1));
        System.out.println(str.compareTo("abcdef"));
        System.out.println(str.compareToIgnoreCase("abcdef"));

        System.out.println(str.concat("ghij"));

        System.out.println(str.contains("bc"));

        System.out.println(str.contentEquals("abcdef"));

        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        //reverseString(chars);

        /*
"krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc"
20
         */
        System.out.println(reverseStr("krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc", 20));
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(s));
    }


    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        if (k < chars.length) {
            int len = chars.length / k;
            for (int i = 0; i < len; i++) {
                if (i % k == 0) {
                    char[] temp = Arrays.copyOfRange(chars, i * k, k + i * k);
                    reserve(temp, k);
                    int j = i * k;
                    for (int l = 0; l < temp.length; l++) {
                        chars[j++] = temp[l];
                    }
                }
            }
            if (len % 2 == 0) {
                int start = chars.length - chars.length % k;
                char[] chars1 = Arrays.copyOfRange(chars, start, chars.length);
                reserve(chars1, chars1.length);
                for (int l = 0; l < chars1.length; l++) {
                    chars[start++] = chars1[l];
                }
            }
        } else {
            reserve(chars, chars.length);
        }
        return new String(chars);



        /*if (s.length() > k) {
            String s1 = s.substring(0, k);
            char[] chars = s1.toCharArray();
            for (int i = 0; i < chars.length/2; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = temp;
            }
            System.out.println(Arrays.toString(chars));

        } else {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = temp;
            }
            System.out.println(Arrays.toString(chars));

        }*/

        //return "";
    }


    public static void reserve(char[] chars, int count) {
        for (int i = 0; i < count / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[count - 1 - i];
            chars[count - 1 - i] = temp;
        }
    }

    public static void stringContructor() {
        String str = "abc";

        char[] data = {'a', 'b', 'c'};
        String str1 = new String(data);

        log.info("str={}  str1={}", str, str1);
    }
}
