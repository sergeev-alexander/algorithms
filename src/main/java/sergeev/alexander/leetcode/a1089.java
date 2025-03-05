package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1089. Duplicate Zeros
public class a1089 {

    /*
    Given a fixed-length integer array arr, duplicate each occurrence of zero,
    shifting the remaining elements to the right.
    Note that elements beyond the length of the original array are not written.
    Do the above modifications to the input array in place and do not return anything.
     */

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    // BEATS 100%
    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] resultArr = new int[n * 2];
        int pos = 0;
        for (int num : arr) {
            if (num == 0) {
                pos++;
            } else {
                resultArr[pos] = num;
            }
            pos++;
        }
        System.arraycopy(resultArr, 0, arr, 0, n);
    }
}