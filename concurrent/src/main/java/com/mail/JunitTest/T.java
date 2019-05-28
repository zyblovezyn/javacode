package com.mail.JunitTest;

public class T {
    public static void main(String[] args) {
        int x = 1;
        int y = 8;
        int res = 0;
        int temp = Integer.max(x, y);
        while (temp != 0) {
            if (x % 2 != y % 2) {
                res++;
            }
            x = x >> 1;
            y = y >> 1;
            temp = temp >> 1;
        }
        System.out.println(res);
        // System.out.println(x ^ y);
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int divide(int x, int y) {
        return x / y;
    }
}
