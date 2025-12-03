package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <a href="https://leetcode.com/problems/rotate-string">796. Rotate String</a>
 */
@RunWith(Enclosed.class)
public class RotateString {

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;

        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
            if (sb.toString().equals(goal))
                return true;
        }
        return false;
    }

    public static boolean rotateString2(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String combined = s + s;
        return combined.contains(goal);
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertTrue(rotateString("abcde", "cdeab"));
            assertFalse(rotateString("abcde", "abced"));
        }
    }
}
