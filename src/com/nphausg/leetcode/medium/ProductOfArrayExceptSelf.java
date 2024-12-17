package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self">238. Product of Array Except Self</a>
 */
@RunWith(Enclosed.class)
public class ProductOfArrayExceptSelf {

    // Brute-force
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    product *= nums[j];
                }
            }
            answer[i] = product;
        }
        for (int j : answer) {
            System.out.print(j + " ");
        }
        return answer;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int[] answer = new int[nums.length];
        int product = 1;
        for (int num : nums) {
            product *= num;
        }
        for (int i = 0; i < answer.length; i++) {
            if (nums[i] != 0) {
                answer[i] = product / nums[i];
            }
        }
        for (int j : answer) {
            System.out.print(j + " ");
        }
        return answer;
    }

    public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            System.out.println(Arrays.toString(productExceptSelf3(new int[]{1, 2, 3, 4})));
            System.out.println(Arrays.toString(productExceptSelf3(new int[]{-1, 1, 0, -3, 3})));
        }
    }
}
