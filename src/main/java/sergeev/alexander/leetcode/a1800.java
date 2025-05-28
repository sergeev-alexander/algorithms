package sergeev.alexander.leetcode;

// 1800. Maximum Ascending Subarray Sum
public class a1800 {

    /*
    Given an array of positive integers nums, return the maximum possible sum of an strictly increasing subarray in nums.
    A subarray is defined as a contiguous sequence of numbers in an array.
     */

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 5, 10, 50};
        System.out.println(maxAscendingSum(arr));
    }

    // BEATS 100%
    public static int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int currenSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currenSum += nums[i];
            } else {
                currenSum = nums[i];
            }
            maxSum = Math.max(maxSum, currenSum);
        }
        return maxSum;
    }
}
