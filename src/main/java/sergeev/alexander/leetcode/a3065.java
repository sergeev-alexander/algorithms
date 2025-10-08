package sergeev.alexander.leetcode;

// 3065. Minimum Operations to Exceed Threshold Value I
public class a3065 {

    /*
    You are given a 0-indexed integer array nums, and an integer k.
    In one operation, you can remove one occurrence of the smallest element of nums.
    Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
     */

    public static void main(String[] args) {
        int[] nums = {1,1,2,4,9};
        int  k = 9;
        System.out.println(minOperations(nums, k));
    }

    // BEATS 100%
    public static int minOperations(int[] nums, int k) {
        int count = 0;

        for (int num : nums) {
            if (num < k) count++;
        }

        return count;
    }
}