package sergeev.alexander.leetcode;

import java.util.Arrays;

//1920. Build Array from Permutation
public class a1920 {

    /*
    Given a zero-based permutation nums (0-indexed),
    build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
    A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
     */

    public static void main(String[] args) {
        int[] arr = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray(arr)));
    }

    // BEATS 98%
    public static int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[nums[i]];
        }

        return arr;
    }
}