package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1464. Maximum Product of Two Elements in an Array
public class a1464 {

    /*
    Given the array of integers nums, you will choose two different indices i and j of that array.
    Return the maximum value of (nums[i]-1)*(nums[j]-1).
     */

    public static void main(String[] args) {
        int[] arr = {10,2,5,2};
        System.out.println(maxProduct(arr));
    }

    // BEATS 100%
    public static int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return --max1 * --max2;
    }

    // BEATS 55%
    public static int maxProduct1(int[] nums) {
        Arrays.sort(nums);
        return --nums[nums.length - 1] * --nums[nums.length - 2];
    }
}