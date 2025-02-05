package sergeev.alexander.leetcode;

// 326. Power of Three
public class a326 {

    /*
    Given an integer n, return true if it is a power of three. Otherwise, return false.
    An integer n is a power of three, if there exists an integer x such that n == 3x.
     */

    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));
    }

    // BEATS 89%
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}