package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/fibonacci-number">509. Fibonacci Number</a>
 */
@RunWith(Enclosed.class)
public class FibonacciNumber {

    public static int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static long fib2(int n) {
        if (n <= 2) return 1L;
        HashMap<Integer, Long> memo = new HashMap<>();
        return fib2Helper(n - 1, memo) + fib2Helper(n - 2, memo);
    }

    public static long fib2Helper(int n, HashMap<Integer, Long> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n <= 2) {
            return 1L;
        }
        long next = fib2Helper(n - 1, memo) + fib2Helper(n - 2, memo);
        memo.put(n, next);
        return next;
    }
 
    public static long fib3(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        long prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n ; i ++){
            long current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(8L, fib3(6));
            assertEquals(13L, fib3(7));
            assertEquals(21L, fib3(8));
            assertEquals(12586269025L, fib3(50));
        }
    }
}
