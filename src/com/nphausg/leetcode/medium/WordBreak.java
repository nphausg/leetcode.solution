package com.nphausg.leetcode.medium;


import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/word-break">139. Word Break</a>
 */
@RunWith(Enclosed.class)
public class WordBreak {

    public static boolean wordBreak(String target, List<String> wordDict) {
        return helper(target, wordDict, new HashMap<>());
    }

    public static Boolean helper(String target, List<String> wordDict, HashMap<String, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (wordDict.contains(target)) {
            return true;
        }
        for (String word : wordDict) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (helper(suffix, wordDict, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        return false;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(true, wordBreak("leetcode", List.of("leet", "code")));
            assertEquals(true, wordBreak("applepenapple", List.of("apple", "pen")));
        }
    }
}
