package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/missing-number">268. Missing Number</a>
 */
@RunWith(Enclosed.class)
public class MissingNumber {

    public static int missingNumber(int n, int[] array) {

        int[] hash = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            hash[array[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static int missingNumber2(int n, int[] array) {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += array[i];
        }
        return n * (n + 1) / 2 - sum;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void test() {
            assertEquals(2, missingNumber(5, new int[]{1, 3, 4, 5}));
            assertEquals(4, missingNumber(5, new int[]{1, 2, 3, 5}));
            assertEquals(5, missingNumber(8, new int[]{1, 2, 4, 6, 3, 7, 8}));
            assertEquals(2, missingNumber2(5, new int[]{1, 3, 4, 5}));
            assertEquals(4, missingNumber2(5, new int[]{1, 2, 3, 5}));
            assertEquals(5, missingNumber2(8, new int[]{1, 2, 4, 6, 3, 7, 8}));
        }
    }
}
