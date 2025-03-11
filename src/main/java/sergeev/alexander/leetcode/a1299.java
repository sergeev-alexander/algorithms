package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1299. Replace Elements with Greatest Element on Right Side
public class a1299 {

    /*
    Given an array arr, replace every element in that array with the greatest element among the elements to its right,
    and replace the last element with -1.
    After doing so, return the array.
     */

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }

    public static int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = max;
            max = Math.max(max, arr[i]);
            arr[i] = temp;
        }
        return arr;
    }

    // BEATS 57%
    public static int[] replaceElements2(int[] arr) {
        int n = arr.length;
        if (n == 1) return new int[]{-1};
        int[] resultArr = new int[n];
        int pos = 0;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i >= pos || max <= 0) {
                pos = 0;
                max = 0;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                        pos = j;
                    }
                }
            }
            resultArr[i] = max;
        }
        resultArr[n - 1] = -1;
        return resultArr;
    }

    // BEATS 21%
    public static int[] replaceElements1(int[] arr) {
        int n = arr.length;
        if (n == 1) return new int[]{-1};
        int[] resultArr = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, arr[j]);
            }
            resultArr[i] = max;
        }
        resultArr[n - 1] = -1;
        return resultArr;
    }
}
