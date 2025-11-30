package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray">53. Maximum Subarray</a>
 */
@RunWith(Enclosed.class)
public class MaximumSubarray {


    // Kadane's Algorithm
    public static int maxSubArrayKadane(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (final int num : nums) {
            sum = Math.max(num, sum + num);
            max = Math.max(max, sum);
        }

        return max;
    }

    public static int maxSubArray3(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    public static int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftMax = maxSubArrayHelper(nums, left, mid);
        int rightMax = maxSubArrayHelper(nums, mid + 1, right);
        int crossMax = maxCrossingSum(nums, left, mid, right);
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }

    public static int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    // O(n^2)
    public static int maxSubArrayBruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(1, maxSubArrayKadane(new int[]{1}));
            assertEquals(23, maxSubArrayKadane(new int[]{5, 4, -1, 7, 8}));
            assertEquals(6, maxSubArrayKadane(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        }
    }
}
