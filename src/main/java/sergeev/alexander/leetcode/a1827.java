package sergeev.alexander.leetcode;

// 1827. Minimum Operations to Make the Array Increasing
public class a1827 {

    /*
    You are given an integer array nums (0-indexed). In one operation, you can choose an element of the array and increment it by 1.
    For example, if nums = [1,2,3], you can choose to increment nums[1] to make nums = [1,3,3].
    Return the minimum number of operations needed to make nums strictly increasing.
    An array nums is strictly increasing if nums[i] < nums[i+1] for all 0 <= i < nums.length - 1.
    An array of length 1 is trivially strictly increasing.
     */

    public static void main(String[] args) {
        int[] arr = {1,5,2,4,1};
        System.out.println(minOperations(arr));
    }

    // BEATS 88%
    public static int minOperations(int[] nums) {
        int count = 0;
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= ++currentMax) {
                count += currentMax - nums[i];
            }
            currentMax = Math.max(currentMax, nums[i]);
        }
        return count;
    }
}