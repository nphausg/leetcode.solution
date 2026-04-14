package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static com.nphausg.leetcode.easy.LC0242ValidAnagram.isAnagram;
import static org.junit.Assert.assertEquals;
/**
 * <a href="https://leetcode.com/problems/find-resultant-array-after-removing-anagrams">2273. Find Resultant Array After Removing Anagrams</a>
 */

@RunWith(Enclosed.class)
public class LC2273FindResultantArrayAfterRemovingAnagrams {

    public static List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length; ) {
            int j = i + 1;
            while (j < words.length && isAnagram(words[i], words[j]))
                ++j;
            ans.add(words[i]);
            i = j;
        }

        return ans;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(List.of("abba", "cd"), removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"}));
            assertEquals(List.of("a", "b", "c", "d", "e"), removeAnagrams(new String[]{"a", "b", "c", "d", "e"}));
        }
    }
}
