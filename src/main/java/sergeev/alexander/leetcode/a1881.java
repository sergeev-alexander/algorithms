package sergeev.alexander.leetcode;

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
        String n = "-132";
        int x = 3;
        System.out.println(maxValue(n, x));
    }

    // BEATS 83%
    public static String maxValue(String n, int x) {
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