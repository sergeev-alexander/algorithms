package sergeev.alexander.algorithms.greatest_common_divisor;

import java.util.Scanner;

public class GreatestCommonDivisorRecursive {

    public static void main(String[] args) {

        long a = 14159572L;
        long b = 63967072L;
        System.out.println(findGreatestCommonDivisor(a, b));
    }

    public static long findGreatestCommonDivisor(long a, long b) {
        if (a == 0L) return b;
        if (b == 0L) return a;
        if (a >= b) return findGreatestCommonDivisor(a % b, b);
        else return findGreatestCommonDivisor(b % a, a);
    }
}
