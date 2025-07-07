package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1913. Maximum Product Difference Between Two Pairs
public class a1923 {

    /*
    The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).
    For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
    Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference
    between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.
    Return the maximum such product difference.
     */

    public static void main(String[] args) {
        int[] arr = {4,2,5,9,7,4,8};
        System.out.println(maxProductDifference(arr));
    }

    // BEATS 74%
    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }
}