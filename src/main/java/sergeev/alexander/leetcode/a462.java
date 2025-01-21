package sergeev.alexander.leetcode;

import java.util.Arrays;

// 462. Minimum Moves to Equal Array Elements II
public class a462 {

    /*
    Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
    In one move, you can increment or decrement an element of the array by 1.
    Test cases are designed so that the answer will fit in a 32-bit integer.
     */

    public static void main(String[] args) {
        int[] nums = {1,10,2,9};
        System.out.println(minMoves2(nums));
    }

    // BEATS 84%
    public static int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = n / 2;
        int target;
        if (n % 2 == 0) {
            target = (nums[mid] + nums[mid -1]) / 2;
        } else target = nums[mid];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(target - num);
        }
        return moves;
    }
}