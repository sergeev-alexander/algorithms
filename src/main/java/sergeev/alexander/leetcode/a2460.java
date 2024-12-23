package sergeev.alexander.leetcode;

import java.util.Arrays;

// 2460. Apply Operations to an Array
public class a2460 {

    /*
    You are given a 0-indexed array nums of size n consisting of non-negative integers.
    You need to apply n - 1 operations to this array where, in the ith operation (0-indexed),
    you will apply the following on the ith element of nums:
    If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
    After performing all the operations, shift all the 0's to the end of the array.
    For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end, is [1,2,1,0,0,0].
    Return the resulting array.
    Note that the operations are applied sequentially, not all at once.
     */

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,0};
        System.out.println(Arrays.toString(applyOperations(nums)));
    }

    // BEATS 100%
    public static int[] applyOperations(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                arr[j++] = 2 * nums[i];
                nums[++i] = 0;
            } else {
                arr[j++] = nums[i];
            }
        }
        return arr;
    }

    // BEATS 96%
    public static int[] applyOperations1(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i + 1] = 0;
                nums[i] *= 2;
            }
            if (nums[i] != 0) {
                arr[j] = nums[i];
                j++;
            }
            if (i == nums.length - 2) {
                arr[j] = nums[i + 1];
            }
        }
        return arr;
    }
}