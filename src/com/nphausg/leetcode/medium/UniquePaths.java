package com.nphausg.leetcode.medium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.nphausg.leetcode.config.BaseTest;

/**
 * <a href="https://leetcode.com/problems/unique-paths">62. Unique Paths</a>
 */
@RunWith(Enclosed.class)
public class UniquePaths {

    public static long uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public static int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        HashMap<String, Integer> memo = new HashMap<>();
        return helper(m, n, memo);
    }

    public static int helper(int m, int n, HashMap<String, Integer> memo) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;

        String key = m + "," + n;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        memo.put(key, helper(m - 1, n, memo) + helper(m, n - 1, memo));
        return memo.get(key);
    }

    public static int uniquePaths3(int m, int n) {
        int totalSteps = m + n - 2;
        int downSteps = m - 1;
        long result = 1;

        for (int i = 1; i <= downSteps; i++) {
            result = result * (totalSteps - downSteps + i) / i;
        }
        return (int) result;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(1, uniquePaths3(1, 1));
            assertEquals(3, uniquePaths3(3, 2));
            assertEquals(3, uniquePaths3(2, 3));
            assertEquals(21, uniquePaths3(6, 3));
            assertEquals(28, uniquePaths3(3, 7));
            //assertEquals(2333606220L, uniquePaths(18, 18));
        }
    }
}
