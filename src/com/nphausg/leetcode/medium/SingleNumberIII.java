package com.nphausg.leetcode.medium;


import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/single-number-iii">260. Single Number III</a>
 */
@RunWith(Enclosed.class)
public class SingleNumberIII {

    public static int[] singleNumber2(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num; // XOR toàn bộ mảng
        }
        int diff = xor & (-xor); // Lấy bit khác biệt
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
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
            assertEquals(1, singleNumber2(new int[]{1}));
            assertEquals(1, singleNumber2(new int[]{2, 2, 1}));
            assertEquals(4, singleNumber2(new int[]{4, 1, 2, 1, 2}));
        }
    }
}
