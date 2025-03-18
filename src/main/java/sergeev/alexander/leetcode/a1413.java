package sergeev.alexander.leetcode;

// 1413. Minimum Value to Get Positive Step by Step Sum
public class a1413 {

    /*
    Given an array of integers nums, you start with an initial positive value startValue.
    In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
    Return the minimum positive value of startValue such that the step by step sum is never less than 1.
     */

    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};
        System.out.println(minStartValue(nums));
    }

    // BEATS 100%
    public static int minStartValue(int[] nums) {
        int min = 101;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return min < 0 ? ((min * -1) + 1) : 1;
    }
}