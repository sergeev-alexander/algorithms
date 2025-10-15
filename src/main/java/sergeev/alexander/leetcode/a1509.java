package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
public class a1509 {

    /*
    You are given an integer array nums.
    In one move, you can choose one element of nums and change it to any value.
    Return the minimum difference between the largest and smallest value of nums after performing at most three moves.
     */

    public static void main(String[] args) {
        int[] nums = {90,35,67,53,61};
        System.out.println(minDifference(nums));
    }

    // BEATS 100%
    public static int minDifference(int[] nums) {
        if (nums.length < 5) return 0;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;

        for (int num : nums) {

            if (num >= max1) {
                max4 = max3;
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max4 = max3;
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max4 = max3;
                max3 = num;
            } else if (num > max4) {
                max4 = num;
            }

            if (num <= min1) {
                min4 = min3;
                min3 = min2;
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min4 = min3;
                min3 = min2;
                min2 = num;
            } else if (num <= min3) {
                min4 = min3;
                min3 = num;
            } else if (num <= min4) {
                min4 = num;
            }
        }

        int minDiff = Integer.MAX_VALUE;

        minDiff = Math.min(minDiff, max1 - min4);
        minDiff = Math.min(minDiff, max4 - min1);
        minDiff = Math.min(minDiff, max2 - min3);
        minDiff = Math.min(minDiff, max3 - min2);

        return minDiff;
    }

    // BEATS 77%
    public static int minDifference1(int[] nums) {
        int n = nums.length;

        if (n < 5) return 0;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        minDiff = Math.min(minDiff, nums[n - 1] - nums[3]);
        minDiff = Math.min(minDiff, nums[n - 4] - nums[0]);
        minDiff = Math.min(minDiff, nums[n - 3] - nums[1]);
        minDiff = Math.min(minDiff, nums[n - 2] - nums[2]);

        return minDiff;
    }
}