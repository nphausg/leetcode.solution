package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

/**
 * <a href="https://leetcode.com/problems/sort-colors">75. Sort Colors</a>
 */
@RunWith(Enclosed.class)
public class SortColors {

    // Bubble Sort-like
    public static void sortColors1(int[] nums) {
        int t;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                }
            }
        }
    }

    // Counting Sort
    public void sortColors2(int[] nums) {
        int[] count = new int[3]; // count[0] = number of 0s, etc.

        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (count[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }

    // Dutch National Flag Algorithm
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            int[] t1 = new int[]{2, 2, 3, 2};
            sortColors(t1);
            assertArrayEquals(new int[]{2, 2, 2, 3}, t1);
            int[] t2 = new int[]{0, 1, 0, 1, 0, 1, 99};
            sortColors(t2);
            assertArrayEquals(new int[]{0, 0, 0, 1, 1, 1, 99}, t2);
        }
    }
}
