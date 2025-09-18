package sergeev.alexander.leetcode;

// 2413. Smallest Even Multiple
public class a2413 {

    /*
    Given a positive integer n, return the smallest positive integer that is a multiple of both 2 and n.
     */

    public static void main(String[] args) {
        int n = 6;
        System.out.println(smallestEvenMultiple(n));
    }

    // BEATS 100%
    public static int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}