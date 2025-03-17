package sergeev.alexander.leetcode;

import java.math.BigInteger;

// 1404. Number of Steps to Reduce a Number in Binary Representation to One
public class a1404 {

    /*
    Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:
    If the current number is even, you have to divide it by 2.
    If the current number is odd, you have to add 1 to it.
    It is guaranteed that you can always reach one for all test cases.
     */

    public static void main(String[] args) {
        String s = "1111110011101010110011100100101110010100101110111010111110110010";
        System.out.println(numSteps(s));
    }

    public static int numSteps(String s) {
        BigInteger num = new BigInteger(s, 2);
        int count = 0;
        while (num.compareTo(BigInteger.ONE) > 0) {
            if (num.remainder(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0) {
                num = num.divide(BigInteger.TWO);
            } else {
                num = num.add(BigInteger.ONE);
            }
            count++;
        }
        return count;
    }
}