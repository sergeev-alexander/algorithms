package sergeev.alexander.leetcode;

import java.util.Arrays;

// 3190. Find Minimum Operations to Make All Elements Divisible by Three
public class a3190 {

    /*
    You are given an integer array nums. In one operation, you can add or subtract 1 from any element of nums.
    Return the minimum number of operations to make all elements of nums divisible by 3.
     */

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        System.out.println(minimumOperations(arr));
    }

    public static int minimumOperations(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 3 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int minimumOperations_COULD_BE_FASTER(int[] nums) {
        return (int) Arrays.stream(nums)
                .filter(i -> i % 3 != 0)
                .count();
    }
}
