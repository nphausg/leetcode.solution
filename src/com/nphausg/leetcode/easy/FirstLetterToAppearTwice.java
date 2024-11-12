package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/first-letter-to-appear-twice">2351. First Letter to Appear Twice</a>
 */

public class FirstLetterToAppearTwice {
    public static char repeatedCharacter(String s) {
        HashSet<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }
        return ' ';
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            // a,3
            // b,2
            // c,3
            // z,1
            assertEquals('c', repeatedCharacter("abccbaacz"));
            assertEquals('d', repeatedCharacter("abcdd"));
        }
    }
}
