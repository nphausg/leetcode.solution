package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
/**
 * <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix">1351. Count Negative Numbers in a Sorted Matrix</a>
 */

@RunWith(Enclosed.class)
public class LC1351CountNegativeNumbersInASortedMatrix {

    public static int countNegatives2(int[][] grid) {
        int count = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] nums : grid) {
            int lastPositiveIndex = findLastPositive(nums);
            System.out.println("lastPositiveIndex: " + lastPositiveIndex);
            if (lastPositiveIndex > -1) {
                System.out.println("count: " + (nums.length - lastPositiveIndex - 1));
                count += nums.length - lastPositiveIndex - 1;
            } else {
                count += nums.length;
            }
        }
        return count;
    }

    private static int findLastPositive(int[] nums) {
        int left = -1, right = nums.length - 1;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] >= 0) left = mid;
            else right = mid - 1;
        }
        return right;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(0, countNegatives(new int[][]{{3, 2}, {1, 0}}));
            assertEquals(8, countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
        }
    }
}
