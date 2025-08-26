package sergeev.alexander.leetcode;

import java.util.Arrays;

// 2164. Sort Even and Odd Indices Independently
public class a2164 {

    /*
    You are given a 0-indexed integer array nums. Rearrange the values of nums according to the following rules:
    Sort the values at odd indices of nums in non-increasing order.
    For example, if nums = [4,1,2,3] before this step, it becomes [4,3,2,1] after. The values at odd indices 1 and 3 are sorted in non-increasing order.
    Sort the values at even indices of nums in non-decreasing order.
    For example, if nums = [4,1,2,3] before this step, it becomes [2,1,4,3] after. The values at even indices 0 and 2 are sorted in non-decreasing order.
    Return the array formed after rearranging the values of nums.
     */

    public static void main(String[] args) {
        int[] arr = {4,1,2,3};
        System.out.println(Arrays.toString(sortEvenOdd(arr)));
    }

    // BEATS 93%
    public static int[] sortEvenOdd(int[] nums) {
        int n = nums.length;

        int[] even = new int[n % 2 == 0 ? n / 2 : n / 2 + 1];
        int[] odd = new int[nums.length - even.length];

        int evenPos = 0;
        int oddPos = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[evenPos++] = nums[i];
            } else {
                odd[oddPos++] = nums[i];
            }
        }

        Arrays.sort(even);
        Arrays.sort(odd);

        evenPos = 0;
        oddPos--;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = even[evenPos++];
            } else {
                nums[i] = odd[oddPos--];
            }
        }

        return nums;
    }
}