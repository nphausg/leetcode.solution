package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
/**
 * <a href="https://leetcode.com/problems/maximum-product-of-three-numbers">628. Maximum Product of Three Numbers</a>
 */

@RunWith(Enclosed.class)
public class LC0628MaximumProductOfThreeNumbers {

    public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE; // the minimum
        int min2 = Integer.MAX_VALUE; // the second minimum
        int max1 = Integer.MIN_VALUE; // the maximum
        int max2 = Integer.MIN_VALUE; // the second maximum
        int max3 = Integer.MIN_VALUE; // the third maximum

        for (final int num : nums) {
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }
        }

        return Math.max(max1 * min1 * min2, max1 * max2 * max3);
    }

    public static int maximumProduct1(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n - 1] * nums[0] * nums[1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(6, maximumProduct(new int[]{1, 2, 3}));
            assertEquals(24, maximumProduct(new int[]{1, 2, 3, 4}));
            assertEquals(-6, maximumProduct(new int[]{-1, -2, -3}));
        }
    }
}
