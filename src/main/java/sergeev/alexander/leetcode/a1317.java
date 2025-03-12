package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1317. Convert Integer to the Sum of Two No-Zero Integers
public class a1317 {

    /*
    No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.
    Given an integer n, return a list of two integers [a, b] where:
    a and b are No-Zero integers.
    a + b = n
    The test cases are generated so that there is at least one valid solution.
    If there are many valid solutions, you can return any of them.
     */

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(Arrays.toString(getNoZeroIntegers(n)));
    }

    // BEATS 100%
    public static int[] getNoZeroIntegers(int n) {
        for (int i = 1, j = n - 1; i < n; i++, j--) {
            if (hasNoZero(i) && hasNoZero(j)) {
                return new int[]{i, j};
            }
        }
        return null;
    }

    public static boolean hasNoZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) return false;
            n /= 10;
        }
        return true;
    }

    // BEATS 43%
    public static int[] getNoZeroIntegers1(int n) {
        for (int i = 1, j = n - 1; i < n; i++, j--) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(j).contains("0")) {
                return new int[]{i, j};
            }
        }
        return null;
    }
}
