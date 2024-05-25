/**
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 */
package com.nphausg.leetcode.hard;

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

    public int firstMissingPositive(int[] numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] < 0)
                numbers[i] = 0;

        for (int i = 0; i < numbers.length; i++) {

            int val = Math.abs(numbers[i]);

            if (val > 0 && val <= numbers.length) {

                if (numbers[val - 1] > 0)
                    numbers[val - 1] *= -1;

                else if (numbers[val - 1] == 0)
                    numbers[val - 1] = -(numbers.length + 1);
            }
        }

        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] >= 0)
                return i + 1;

        return numbers.length + 1;
    }
}
