package com.java12.collections.deque;

import java.util.ArrayDeque;

/**
 * @author zyb
 * @title: ArrayDequeTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/25 0025 21:22
 */
public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>(1);
        arrayDeque.add(1);
        arrayDeque.add(2);
        arrayDeque.add(3);
        arrayDeque.remove();
    }
}
