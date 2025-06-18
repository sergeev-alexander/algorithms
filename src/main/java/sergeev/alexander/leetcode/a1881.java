package sergeev.alexander.leetcode;

import java.util.function.Predicate;

// 1881. Maximum Value after Insertion
public class a1881 {

    /*
    You are given a very large integer n, represented as a string, and an integer digit x.
    The digits in n and the digit x are in the inclusive range [1, 9], and n may represent a negative number.
    You want to maximize n's numerical value by inserting x anywhere in the decimal representation of n.
    You cannot insert x to the left of the negative sign.
    For example, if n = 73 and x = 6, it would be best to insert it between 7 and 3, making n = 763.
    If n = -55 and x = 2, it would be best to insert it before the first 5, making n = -255.
    Return a string representing the maximum value of n after the insertion.
     */

    public static void main(String[] args) {
        String n = "13";
        int x = 2;
        System.out.println(maxValue(n, x));
    }

    // BEATS 83%
    public static String maxValue(String n, int x) {
        StringBuilder stringBuilder = new StringBuilder(n);
        boolean isNegative = n.charAt(0) == '-';

        for (int i = isNegative ? 1 : 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if (!isNegative && num < x || isNegative && num > x) {
                return stringBuilder.insert(i, x).toString();
            }
        }

        return stringBuilder.append(x).toString();

    }

    // BEATS 83%
    public static String maxValue2(String n, int x) {
        StringBuilder stringBuilder = new StringBuilder(n);
        char[] arr = n.toCharArray();
        if (arr[0] != '-') {

            for (int i = 0; i < arr.length; i++) {
                if ((int) arr[i] - '0' < x)
                    return stringBuilder.insert(i, x).toString();
            }

        } else {

            for (int i = 1; i < arr.length; i++) {
                if ((int) arr[i] - '0' > x)
                    return stringBuilder.insert(i, x).toString();
            }

        }
        return stringBuilder.append(x).toString();
    }

    // BEATS 83%
    public static String maxValue1(String n, int x) {
        StringBuilder stringBuilder = new StringBuilder(n);
        if (!n.startsWith("-")) {

            for (int i = 0; i < n.length(); i++) {
                if ((int) stringBuilder.charAt(i) - '0' < x) {
                    stringBuilder.insert(i, x);
                    return stringBuilder.toString();
                }
            }

            stringBuilder.append(x);
        } else {

            for (int i = 1; i < n.length(); i++) {
                if ((int) stringBuilder.charAt(i) - '0' > x) {
                    stringBuilder.insert(i, x);
                    return stringBuilder.toString();
                }
            }

            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }
}