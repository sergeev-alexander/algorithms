package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1502. Can Make Arithmetic Progression From Sequence
public class a1502 {

    /*
    A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
    Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression.
    Otherwise, return false.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,4};
        System.out.println(canMakeArithmeticProgression(arr));
    }

    // BEATS 97%
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[0] - arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] - arr[i] != diff) {
                return false;
            }
        }
        return true;
    }
}