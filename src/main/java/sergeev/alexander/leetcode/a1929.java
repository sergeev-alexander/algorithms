package sergeev.alexander.leetcode;

import java.util.Arrays;

//1929. Concatenation of Array
public class a1929 {

    /*
    Given an integer array nums of length n,
    you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
    Specifically, ans is the concatenation of two nums arrays.
    Return the array ans.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        System.out.println(Arrays.toString(getConcatenation(arr)));
    }

    // BEATS 96%
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] resultArray = new int[n * 2];

        for (int i = 0; i < n; i++) {
            resultArray[i] = nums[i];
            resultArray[i + n] = nums[i];
        }

        return resultArray;
    }
}