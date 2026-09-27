
package com.nphausg.leetcode.easy;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.nphausg.leetcode.config.BaseTest;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/crawler-log-folder">1598. Crawler Log Folder</a>
 */

@RunWith(Enclosed.class)
public class LC1598CrawlerLogFolder {

    public static int minOperations(String[] logs) {
        int depth = 0;
        String backToMainFolder = "../";
        String remainSameFolder = "./";

        for (String log : logs) {

            if(log.equals(backToMainFolder)){
                if (depth > 0) {
                    depth--;
                }
            } else if (log.equals(remainSameFolder)) {
                continue;
            } else {
                depth++;
            }
        }
        return depth;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void test() {
            assertEquals(0, minOperations(new String[]{"d1/","../","../","../"}));
            assertEquals(2, minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
            assertEquals(3, minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
        }
    }
}
