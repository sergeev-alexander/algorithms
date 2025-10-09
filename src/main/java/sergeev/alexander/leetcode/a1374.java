package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1374. Generate a String With Characters That Have Odd Counts
public class a1374 {

    /*
    Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.
    The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.
     */

    public static void main(String[] args) {
        System.out.println(generateTheString(6));
    }

    // BEATS 100%
    public static String generateTheString(int n) {
        char[] arr = new char[n];

        if (n % 2 != 0) {
            Arrays.fill(arr, 'a');
        } else {
            Arrays.fill(arr, 1, n, 'a');
            arr[0] = 'b';
        }

        return new String(arr);
    }
}