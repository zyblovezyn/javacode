package com.mail.data_struct;

public class reversewords {
    public static void main(String[] args) {
        String s="Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        String[] strings = s.split(" ");
        for (String string : strings) {
            sb.append(reverseWord(string)).append(" ");
        }
        sb.delete(sb.length()-1,sb.length());
        return sb.toString();
    }

    public static char[] reverseWord(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return chars;
    }
}
