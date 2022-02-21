/**
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 */
package sg.nphau.leetcode.hard;

import java.util.Arrays;

public class FirstMissingPositive {

    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int min = 1;
        for (int i : numbers) {
            if (i == min) {
                min++;
            }
        }
        return min;
    }
}
