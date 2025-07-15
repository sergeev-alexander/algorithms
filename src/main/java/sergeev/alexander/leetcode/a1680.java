package sergeev.alexander.leetcode;

import java.math.BigInteger;

// 1680. Concatenation of Consecutive Binary Numbers
public class a1680 {

    /*
    Given an integer n,
    return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, modulo 109 + 7.
     */

    public static void main(String[] args) {
        int n = 12;
        System.out.println(concatenatedBinary(n));
    }

    // TLE
    public static int concatenatedBinary(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            stringBuilder.append(Integer.toBinaryString(i));
        }

        return new BigInteger(stringBuilder.toString(), 2)
                .mod(new BigInteger(String.valueOf((int) 1e9+7)))
                .intValue();
    }

    // BEATS 5%
    public static int concatenatedBinary2(int n) {
        BigInteger result = BigInteger.ZERO;

        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            result = result.shiftLeft(binary.length())
                    .add(new BigInteger(binary, 2))
                    .mod(BigInteger.valueOf((int) 1e9 + 7));
        }

        return result.intValue();
    }

    // BEATS 55%
    public static int concatenatedBinary1(int n) {
        long result = 0L;

        for (int i = 1; i <= n; i++) {
            int bitLength = Integer.SIZE - Integer.numberOfLeadingZeros(i);
            result = (result << bitLength) | i;
            result %= (int) 1e9 + 7;
        }

        return (int) result;
    }
}