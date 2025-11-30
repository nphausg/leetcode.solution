package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/rotate-array/">189. Rotate Array</a>
 */
@RunWith(Enclosed.class)
public class RotateArray {


    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k > 0) {
            int a = nums.length - k;
            revert(nums, 0, a - 1);
            revert(nums, a, nums.length - 1);
            revert(nums, 0, nums.length - 1);
        }
    }

    public static void revert(int[] nums, int left, int right) {
        if (nums == null || nums.length == 1) {
            return;
        }
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // Intermediate array, Space = O(n), Time = O(n)
    public static void rotate1(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }

        int j = 0;
        for (int i = k; i < nums.length; i++) {
            result[i] = nums[j];
            j++;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    // Bubble Rotate O(n*k) -> Time Limit Exceeded
    public static void rotate2(int[] nums, int k) {
        if (nums != null && k > 0) {
            for (int i = 0; i < k; i++) {
                for (int j = nums.length - 1; j > 0; j--) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
            rotate(nums1, 3);
            System.out.println(Arrays.toString(nums1));
            int[] nums2 = new int[]{-1, -100, 3, 99};
            rotate(nums2, 2);
            System.out.println(Arrays.toString(nums2));
        }
    }
}
