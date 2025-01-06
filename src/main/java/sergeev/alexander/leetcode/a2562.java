package sergeev.alexander.leetcode;

// 2562. Find the Array Concatenation Value
public class a2562 {

    /*
    You are given a 0-indexed integer array nums.
    The concatenation of two numbers is the number formed by concatenating their numerals.
    For example, the concatenation of 15, 49 is 1549.
    The concatenation value of nums is initially equal to 0. Perform this operation until nums becomes empty:
    If there exists more than one number in nums, pick the first element and last element in nums respectively
    and add the value of their concatenation to the concatenation value of nums,
    then delete the first and last element from nums.
    If one element exists, add its value to the concatenation value of nums, then delete it.
    Return the concatenation value of the nums.
     */

    public static void main(String[] args) {
        int[] nums = {5,14,13,8,12};
        System.out.println(findTheArrayConcVal(nums));
    }

    // BEATS 98%
    public static long findTheArrayConcVal(int[] nums) {
        long sum = 0;
        int leftPos = 0;
        int rightPos = nums.length - 1;
        while (leftPos <= rightPos) {
            if (leftPos == rightPos) {
                sum += nums[leftPos];
                break;
            }
            int p = (int) Math.log10(nums[rightPos]) + 1;
            sum += nums[rightPos--] + (nums[leftPos++] * (long) Math.pow(10, p));
        }
        return sum;
    }
}