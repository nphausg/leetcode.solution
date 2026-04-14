/**
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 */
package com.nphausg.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/concatenation-of-array">1929. Concatenation of Array</a>
 */
public class LC1929ConcatenationArray {

    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ans[i + nums.length] = nums[i];
        }
        return ans;
    }

}
