package sergeev.alexander.leetcode;

import java.util.Arrays;

// 2587. Rearrange Array to Maximize Prefix Score
public class a2587 {

    /*
    You are given a 0-indexed integer array nums.
    You can rearrange the elements of nums to any order (including the given order).
    Let prefix be the array containing the prefix sums of nums after rearranging it.
    In other words, prefix[i] is the sum of the elements from 0 to i in nums after rearranging it.
    The score of nums is the number of positive integers in the array prefix.
    Return the maximum score you can achieve.
     */

    public static void main(String[] args) {
        int[] arr = {2,-1,0,1,-3,3,-3};
        System.out.println(maxScore(arr));
    }

    // BEATS 93%
    public static int maxScore(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int pos = nums.length - 1;
        long currentSum = 0;
        while (pos >= 0 && currentSum + nums[pos] > 0) {
            currentSum += nums[pos];
            count++;
            pos--;
        }
        return count;
    }
}