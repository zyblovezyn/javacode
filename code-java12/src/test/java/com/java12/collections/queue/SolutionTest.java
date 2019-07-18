package com.java12.collections.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zyb
 * @title: SolutionTest
 * @projectName code-java12
 * @description: TODO
 * @date 2019/7/18 0018 21:31
 */
public class SolutionTest {

    @Test
    public void twoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        System.out.println(solution.twoSum(nums, target));
    }
}