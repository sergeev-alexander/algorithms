package sergeev.alexander.leetcode;

import java.util.Arrays;

// 283. Move Zeroes
public class a283 {

    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.
     */

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // BEATS 84%
    public static void moveZeroes(int[] nums) {
        int lastNonZeroPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                lastNonZeroPos++;
                int temp = nums[lastNonZeroPos];
                nums[lastNonZeroPos] = nums[i];
                nums[i] = temp;
            }
        }
    }

    // BEATS 8%
    public static void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int pos = i;
                while (pos < nums.length && nums[pos] == 0) {
                    pos++;
                }
                if (pos < nums.length) {
                    nums[i] = nums[pos];
                    nums[pos] = 0;
                }
            }
        }
    }
}