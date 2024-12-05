package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/points-that-intersect-with-cars">2848. Points That Intersect With Cars</a>
 */
@RunWith(Enclosed.class)
public class PointsThatIntersectWithCars {
    public static int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer> result = new HashSet<>();
        for (List<Integer> pointsAtI : nums) {
            int start = pointsAtI.get(0);
            int end = pointsAtI.get(1);
            for (int j = start; j <= end; j++) {
                result.add(j);
            }
        }
        return result.size();
    }

    public static int numberOfPoints2(List<List<Integer>> nums) {
        int[] count = new int[102];

        for (List<Integer> car : nums) {
            int start = car.get(0);
            int end = car.get(1);
            count[start]++;
            count[end + 1]--;
        }

        int active = 0, result = 0;

        for (int i = 0; i <= 100; i++) {
            active += count[i];
            if (active > 0) {
                result++;
            }
        }

        return result;
    }


    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
//            Input: nums = [[3,6],[1,5],[4,7]]
//            Output: 7
//            Explanation: All the points from 1 to 7 intersect at least one car, therefore the answer would be 7.
            assertEquals(7, numberOfPoints2(Arrays.asList(
                    Arrays.asList(3, 6),
                    Arrays.asList(1, 5),
                    Arrays.asList(4, 7)
            )));
//            Input: nums = [[1,3],[5,8]]
//            Output: 7
//            Explanation: Points intersecting at least one car are 1, 2, 3, 5, 6, 7, 8. There are a total of 7 points, therefore the answer would be 7.
            assertEquals(7, numberOfPoints2(Arrays.asList(
                    Arrays.asList(1, 3),
                    Arrays.asList(5, 8)
            )));
        }
    }
}
