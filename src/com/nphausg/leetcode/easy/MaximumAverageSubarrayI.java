package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import com.nphausg.leetcode.medium.LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/maximum-average-subarray-i">Maximum Average Subarray I</a>
 */
public class MaximumAverageSubarrayI {

    public static double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += nums[j];
            }
            double currentAverage = (double) currentSum / k;
            max = Math.max(max, currentAverage);
        }
        return max;
    }

    public static class MaximumAverageSubarrayITest extends BaseTest {

        @org.junit.Test
        public void testCases() {
            /*
              Example 1:
              Input: s = "abcabcbb"
              Output: 3
              Explanation: The answer is "abc", with the length of 3.
             */
            assertEquals(12.75000, MaximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 0.0);
            /*
                Example 2:
                Input: s = "bbbbb"
                Output: 1
                Explanation: The answer is "b", with the length of 1.
            */
            assertEquals(1, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring3("bbbbb"));

            /*
                Example 3:
                Input: s = "pwwkew"
                Output: 3
                Explanation: The answer is "wke", with the length of 3.
                Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
            */
            assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring3("pwwkew"));
        }
    }
}
