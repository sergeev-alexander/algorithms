package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1470. Shuffle the Array
public class a1470 {

    /*
    Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
    Return the array in the form [x1,y1,x2,y2,...,xn,yn].
     */

    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4,7};
        int n = 3;
        System.out.println(Arrays.toString(shuffle(arr, n)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int l = n * 2;
        int[] result = new int[l];
        for (int i = 0, j = 0; i < l; i++) {
            if (i % 2 == 0) {
                result[i] = nums[j++];
            } else {
                result[i] = nums[n++];
            }
        }
        return result;
    }
}