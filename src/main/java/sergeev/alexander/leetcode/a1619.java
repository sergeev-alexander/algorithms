package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1619. Mean of Array After Removing Some Elements
public class a1619 {

    /*
    Given an integer array arr, return the mean of the remaining integers after removing the smallest 5%
    and the largest 5% of the elements.
    Answers within 10-5 of the actual answer will be considered accepted.
     */

    public static void main(String[] args) {
        int[] arr = {6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1,
                0, 6, 10, 8, 2, 3, 4};
        System.out.println(trimMean(arr));
    }

    // BEATS 98%
    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int redundant = (int) (arr.length * 0.05);
        int sum = 0;
        for (int i = redundant; i < (arr.length - redundant); i++) {
            sum += arr[i];
        }
        return sum / (arr.length - redundant * 2.0);
    }
}