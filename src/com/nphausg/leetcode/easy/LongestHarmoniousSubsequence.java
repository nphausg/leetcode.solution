package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/longest-harmonious-subsequence">594. Longest Harmonious Subsequence</a>
 */
public class LongestHarmoniousSubsequence {

    public static int findLHS(int[] nums) {
        int n = nums.length, start = 0, maxLength = 0;
        Arrays.sort(nums);
        for (int end = 0; end < n; end++) {
            while (nums[end] - nums[start] > 1) {
                start++;
            }
            if (nums[end] - nums[start] == 1) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }
        return maxLength;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(2, findLHS(new int[]{1, 2, 3, 4}));
            assertEquals(0, findLHS(new int[]{1, 1, 1, 1}));
            assertEquals(5, findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        }
    }
}
