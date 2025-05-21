package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">69. Sqrt</a>
 * idea: r * r <= x < (r + 1) * (r + 1)
 */
@RunWith(Enclosed.class)
public class Sqrt {

    public static int mySqrt(int x) {
        if (x < 0) return 0;
        if (x < 2) return x;
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public static int mySqrt1(int x) {
        if (x < 0) return 0;
        if (x < 2) return x;
        for (int i = 1; i <= x / 2; i++) {
            if (i <= x / i && (i + 1) > x / (i + 1)) {
                return i;
            }
        }
        return 1;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(0, mySqrt(-1));
            assertEquals(0, mySqrt(0));
            assertEquals(1, mySqrt(1));
            assertEquals(2, mySqrt(4));
            assertEquals(2, mySqrt(8));
            assertEquals(46339, mySqrt(2147395599));
        }
    }
}
