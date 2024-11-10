package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-ii">Contains duplicate II</a>
 */
public class ContainsDuplicate2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length ; i ++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums [i - k]);
            }
        }
        return false;
    }

    public static class ContainsDuplicate2Test extends BaseTest {

        @org.junit.Test
        public void testCases() {
            //assertTrue(ContainsDuplicate2.containsDuplicate(new int[]{1,0,1,1}, 1));
            //assertTrue(ContainsDuplicate2.containsDuplicate(new int[]{1, 2, 3, 1}, 3));
            assertFalse(ContainsDuplicate2.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        }
    }
}
