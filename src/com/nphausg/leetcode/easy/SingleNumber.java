package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/single-number">136. Single Number</a>
 */
public class SingleNumber {
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
            assertEquals(1, singleNumber(new int[]{1}));
            assertEquals(1, singleNumber(new int[]{2, 2, 1}));
            assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
        }
    }
}
