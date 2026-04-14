package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * <a href="https://leetcode.com/problems/sum-of-square-numbers">633. Sum of Square Numbers</a>
 */

@RunWith(Enclosed.class)
public final class SumOfSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        return true;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertTrue(judgeSquareSum(5));
            assertFalse(judgeSquareSum(4));
        }
    }
}
