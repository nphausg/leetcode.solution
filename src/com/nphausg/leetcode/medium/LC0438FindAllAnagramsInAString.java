package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;
/**
 * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string">438. Find All Anagrams in a String</a>
 */
@RunWith(Enclosed.class)
public class LC0438FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        return Collections.emptyList();
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            System.out.println(findAnagrams("abab", "ab"));
            System.out.println(findAnagrams("cbaebabacd", "abc"));
        }
    }
}
