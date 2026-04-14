package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
/**
 * <a href="https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer">2529. Maximum Count of Positive Integer and Negative Integer</a>
 */

@RunWith(Enclosed.class)
public class LC2529MaximumCountOfPositiveIntegerAndNegativeInteger {

    public static int maximumCount(int[] nums) {
        int countPos = 0;
        int countNeg = 0;
        for (int num : nums) {
            if (num > 0) {
                countPos++;
            }
            if (num < 0) {
                countNeg++;
            }
        }
        return Math.max(countPos, countNeg);
    }

    // Method calculates the maximum count of either 0's or 1's in a sorted binary array
    public int maximumCount2(int[] nums) {
        // Find the number of 1's by subtracting the index of the first 1 from the array length
        int countOfOnes = nums.length - firstOccurrence(nums, 1);
        // Find the first occurrence index of 0, which is also the count of 0's
        int countOfZeros = firstOccurrence(nums, 0);
        // Return the max count between 0's and 1's
        return Math.max(countOfOnes, countOfZeros);
    }

    // Helper method to find the first occurrence index of 'x' in the sorted array 'nums'
    private int firstOccurrence(int[] nums, int x) {
        int left = 0;
        int right = nums.length;
        // Binary search to find the first occurrence of 'x'
        while (left < right) {
            int mid = (left + right) >> 1; // Equivalent to (left + right) / 2 but faster
            // If mid element is greater than or equal to x, we move the right boundary
            if (nums[mid] >= x) {
                right = mid;
            } else {
                // If mid element is less than x, we move the left boundary
                left = mid + 1;
            }
        }
        // 'left' will point to the first occurrence of 'x' or nums.length if 'x' is not found
        return left;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(3, maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
            assertEquals(3, maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));
            assertEquals(4, maximumCount(new int[]{5, 20, 66, 1314}));
        }
    }
}
