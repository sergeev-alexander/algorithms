package sergeev.alexander.leetcode;

import java.util.Arrays;

// 238. Product of Array Except Self
public class a238 {

    /*
    Given an integer array nums, return an array answer such that answer[i]
    is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.
     */

    public static void main(String[] args) {
        int[] arr = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    // BEATS 88%
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int leftProduct = 1;
        int[] resultArray = new int[n];
        for (int i = 0; i < n; i++) {
            resultArray[i] = leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            resultArray[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return resultArray;
    }
}