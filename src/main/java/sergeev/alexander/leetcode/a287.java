package sergeev.alexander.leetcode;

// 287. Find the Duplicate Number
public class a287 {

    /*
    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    There is only one repeated number in nums, return this repeated number.
    You must solve the problem without modifying the array nums and using only constant extra space.
     */

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    // BEATS 97%
    public static int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            arr[num - 1]++;
            if (arr[num - 1] > 1) return num;
        }
        return -1;
    }
}