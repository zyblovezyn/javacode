package com.mail.JDK.lambda;

import java.util.Arrays;
import java.util.function.Function;

public class Lambda {

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        System.out.println(lambda.compute(1, value -> {
            return 2 * value;
        }));

        System.out.println(lambda.compute(2, value -> 5 + value));

        System.out.println(lambda.compute(3, x -> x * x));

        System.out.println(lambda.convert(5, x -> x + "hello"));
    }

    public int compute(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            } else {
                i++;
            }
        }
        return nums[nums.length-1];
    }
}
