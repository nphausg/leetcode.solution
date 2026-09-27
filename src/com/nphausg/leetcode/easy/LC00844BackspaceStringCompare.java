package com.nphausg.leetcode.easy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.nphausg.leetcode.config.BaseTest;

/**
 * <a href="https://leetcode.com/problems/backspace-string-compare">844. Backspace String Compare</a>
 */

@RunWith(Enclosed.class)
public class LC00844BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                result.append(c);
            } else if (!result.isEmpty()) {
                result.deleteCharAt(result.length() - 1);
            }
        }
        return result.toString();
    }

    private static boolean twoPointers(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            j = previousValidIndex(s, i);
            i = previousValidIndex(t, j);
            if (i < 0 || j < 0) {
                return i == j;
            }
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    private static int previousValidIndex(String str, int index) {
        int skip = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void test() {
            assertTrue(backspaceCompare("ab#c", "ad#c"));
            assertTrue(backspaceCompare("ab##", "c#d#"));
            assertFalse(backspaceCompare("a#c", "b"));
            assertTrue(backspaceCompare("a##c", "#a#c"));
            assertTrue(backspaceCompare("a#b#c", "a#b#c"));
        }
    }
}
