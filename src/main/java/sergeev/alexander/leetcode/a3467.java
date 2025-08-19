package sergeev.alexander.leetcode;

import java.util.Arrays;

// 3467. Transform Array by Parity
public class a3467 {

    /*
    You are given an integer array nums. Transform nums by performing the following operations in the exact order specified:
    Replace each even number with 0.
    Replace each odd numbers with 1.
    Sort the modified array in non-decreasing order.
    Return the resulting array after performing these operations.
     */

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        System.out.println(Arrays.toString(transformArray(arr)));
    }

    // BEATS 100%
    public static int[] transformArray(int[] nums) {
        int oddCount = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        int n = nums.length;
        int[] arr = new int[n];

        while (oddCount-- > 0) {
            arr[--n]++;
        }

        return arr;
    }
}