package com.nphausg.leetcode.easy;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.nphausg.leetcode.config.BaseTest;

/**
 * <a href="https://leetcode.com/problems/n-th-tribonacci-number">1137. N-th Tribonacci Number</a>
 */
@RunWith(Enclosed.class)
public class NthTribonacciNumber {

    public static long tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int a = 0, b = 1, c = 1, d = 0;
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }

    public static long tribonacci2(int n) {
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        return helper(n, memo);
    }

    public static long helper(int n, long[] memo){
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        if(memo[n] != -1)
            return memo[n];
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo) + helper(n - 3, memo);
        return memo[n];
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(4L, tribonacci2(4));
            assertEquals(1389537L, tribonacci2(25));
        }
    }
}
