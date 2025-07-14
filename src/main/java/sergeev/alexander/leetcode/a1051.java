package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1051. Height Checker
public class a1051 {

    /*
    A school is trying to take an annual photo of all the students.
    The students are asked to stand in a single file line in non-decreasing order by height.
    Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
    You are given an integer array heights representing the current order that the students are standing in.
    Each heights[i] is the height of the ith student in line (0-indexed).
    Return the number of indices where heights[i] != expected[i].
     */

    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(arr));
    }

    // BEATS 88%
    public static int heightChecker(int[] heights) {
        int n = heights.length;
        int[] sortedArray = new int[n];
        System.arraycopy(heights, 0, sortedArray, 0, n);
        Arrays.sort(sortedArray);
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (heights[i] != sortedArray[i]) count++;
        }

        return count;
    }
}