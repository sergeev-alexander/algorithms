package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1480. Running Sum of 1d Array
public class a1480 {

    /*
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(arr)));
    }

    // BEATS 100%
    public static int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}