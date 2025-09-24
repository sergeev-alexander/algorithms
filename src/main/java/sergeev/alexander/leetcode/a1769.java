package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1769. Minimum Number of Operations to Move All Balls to Each Box
public class a1769 {

    public static void main(String[] args) {
        String s = "001011";
        System.out.println(Arrays.toString(minOperations(s)));
    }

    // BEATS 30%
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] arr = new int[n];
        int pos = 0;

        while (pos < n) {
            for (int i = 0; i < n; i++) {
                if (boxes.charAt(i) == '1') {
                    arr[pos] += Math.abs(i - pos);
                }
            }
            pos++;
        }

        return arr;
    }
}
