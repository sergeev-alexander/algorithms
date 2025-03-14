package sergeev.alexander.leetcode;

import java.util.Arrays;

//1365. How Many Numbers Are Smaller Than the Current Number
public class a1365 {

    /*
    Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
    That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
    Return the answer in an array.
     */

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] result = new int[nums.length];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }
        System.out.println(Arrays.toString(count));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = count[nums[i] - 1];
            }
        }
        return result;
    }

    // BEATS 27%
    public static int[] smallerNumbersThanCurrent1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] > nums[j] && i != j) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}