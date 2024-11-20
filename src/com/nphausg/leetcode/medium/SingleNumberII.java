package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/single-number-ii">137. Single Number II</a>
 */
public class SingleNumberII {

    public static int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(3, singleNumber2(new int[]{2, 2, 3, 2}));
            assertEquals(99, singleNumber2(new int[]{0, 1, 0, 1, 0, 1, 99}));
        }
    }
}
