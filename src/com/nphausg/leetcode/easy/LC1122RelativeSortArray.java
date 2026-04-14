package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;
/**
 * <a href="https://leetcode.com/problems/relative-sort-array">1122. Relative Sort Array</a>
 */

@RunWith(Enclosed.class)
public class LC1122RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int[] count = new int[1001];
        int i = 0;
        for (int a : arr1) {
            ++count[a];
        }
        for (int a : arr2) {
            while (count[a]-- > 0) {
                ans[i++] = a;
            }
        }
        for (int num = 0; num < 1001; ++num) {
            while (count[num]-- > 0) {
                ans[i++] = num;
            }
        }
        return ans;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertArrayEquals(new int[]{22, 28, 8, 6, 17, 44},
                    relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6}));
            assertArrayEquals(new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19},
                    relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}));
        }
    }
}
