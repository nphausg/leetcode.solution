package com.nphausg.leetcode.easy;


import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/binary-search">704. Binary Search</a>
 */
@RunWith(Enclosed.class)
public class BinarySearch {

    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // Initialize the starting index of the search range.
            int left = 0;
            // Initialize the ending index of the search range.
            int right = nums.length - 1;
            // Continue searching while the range has more than one element.
            while (left <= right) {
                // Calculate the middle index of the current range.
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
            assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        }
    }
}
