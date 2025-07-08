package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.Map;

// 2001. Number of Pairs of Interchangeable Rectangles
public class a2001 {

    /*
    You are given n rectangles represented by a 0-indexed 2D integer array rectangles,
    where rectangles[i] = [widthi, heighti] denotes the width and height of the ith rectangle.
    Two rectangles i and j (i < j) are considered interchangeable if they have the same width-to-height ratio. More formally, two rectangles are interchangeable if widthi/heighti == widthj/heightj (using decimal division, not integer division).
    Return the number of pairs of interchangeable rectangles in rectangles.
     */

    public static void main(String[] args) {
        int[][] arr = {{4,8},{3,6},{10,20},{15,30}};
        System.out.println(interchangeableRectangles(arr));
    }

    // BEATS 97%
    public static long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> map = new HashMap<>();

        for (int[] arr : rectangles) {
            map.merge((double) arr[0] / arr[1], 1, Integer::sum);
        }

        long count = 0;
        for (int val : map.values()) {
            if (val > 1) count+= (long) val * (val - 1) / 2;
        }

        return count;
    }

    // TLE
    public static long interchangeableRectangles1(int[][] rectangles) {
        int n = rectangles.length;
        long count = 0;

        for (int i = 0; i < n - 1; i++) {
            double currentRatio = (double) rectangles[i][0] / rectangles[i][1];
            for (int j = i + 1; j < n; j++) {
                if (currentRatio == (double) rectangles[j][0] / rectangles[j][1]) count++;
            }
        }

        return count;
    }
}