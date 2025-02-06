package sergeev.alexander.leetcode;

// 231. Power of Two
public class a231 {

    /*
    Given an integer n, return true if it is a power of two. Otherwise, return false.
    An integer n is a power of two, if there exists an integer x such that n == 2^x.
     */

    public static void main(String[] args) {
        int n = 17;
        System.out.println(isPowerOfTwo(n));
    }

    // BEATS 100%
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // BEATS 41%
    public static boolean isPowerOfTwo1(int n) {
        if (n == 0) return false;
        if (n == 1 || n == 2) return true;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}