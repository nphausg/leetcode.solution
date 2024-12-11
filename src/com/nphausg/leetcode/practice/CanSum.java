package com.nphausg.leetcode.practice;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class CanSum {

    public static boolean canSum(int targetSum, int[] array) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int j : array) {
            int r = targetSum - j;
            if (canSum(r, array)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canSum2(int targetSum, int[] array) {
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return helper(targetSum, array, memo);
    }

    public static boolean helper(int targetSum, int[] array, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int j : array) {
            int r = targetSum - j;
            if (helper(r, array, memo)) {
                memo.put(targetSum, true);
                return true;
            }

        }
        memo.put(targetSum, false);
        return false;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void test() {
            assertTrue(canSum(5, new int[]{2, 3}));
            assertTrue(canSum(7, new int[]{5, 3, 4, 7}));
            assertTrue(canSum(8, new int[]{2, 3, 5}));
            assertFalse(canSum(7, new int[]{2, 4}));
            assertFalse(canSum2(300, new int[]{7, 14}));
        }
    }
}
