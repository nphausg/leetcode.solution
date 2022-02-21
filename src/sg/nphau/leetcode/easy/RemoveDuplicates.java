/**
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * </p>
 */
package sg.nphau.leetcode.easy;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pos]) {
                nums[++pos] = nums[i];
            }
        }
        return pos + 1;
    }
}
