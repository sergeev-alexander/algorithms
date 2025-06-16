package sergeev.alexander.leetcode;

// 1837. Sum of Digits in Base K
public class a1837 {

    /*
    Given an integer n (in base 10) and a base k, return the sum of the digits of n after converting n from base 10 to base k.
    After converting, each digit should be interpreted as a base 10 number, and the sum should be returned in base 10.
     */

    public static void main(String[] args) {
        int num = 34;
        int base = 6;
        System.out.println(sumBase(num, base));
    }

    // BEATS 100%
    public static int sumBase(int n, int k) {
        int sum = 0;

        while (n > 0) {
            int quotient = n / k;
            int remainder = n % k;
            n = quotient;
            sum += remainder;
        }

        return sum;
    }
}