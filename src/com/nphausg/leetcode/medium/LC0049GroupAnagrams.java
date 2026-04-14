package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * <a href="https://leetcode.com/problems/group-anagrams">49. Group Anagrams</a>
 */
@RunWith(Enclosed.class)
public class LC0049GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        } else if (strs.length == 1) {
            result.add(Arrays.asList(strs));
        } else {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                map.putIfAbsent(sorted, new ArrayList<>());
                map.get(sorted).add(str);
            }
            return new ArrayList<>(map.values());
        }
        return result;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            System.out.println(groupAnagrams(new String[]{""}));
            System.out.println(groupAnagrams(new String[]{"a"}));
            System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        }
    }
}
