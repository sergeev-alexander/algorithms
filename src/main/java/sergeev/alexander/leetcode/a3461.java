package sergeev.alexander.leetcode;

// 3461. Check If Digits Are Equal in String After Operations I
public class a3461 {

    /*
    You are given a string s consisting of digits. Perform the following operation repeatedly until the string has exactly two digits:
    For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
    Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.
    Return true if the final two digits in s are the same; otherwise, return false.
     */

    public static void main(String[] args) {
        String s = "3902";
        System.out.println(hasSameDigits(s));
    }

    // BEATS 71%
    public static boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                stringBuilder.append((s.charAt(i - 1) - '0' + s.charAt(i) - '0') % 10);
            }
            s = stringBuilder.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }

    // BEATS 22%
    public static boolean hasSameDigits1(String s) {
        while (s.length() > 2) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                stringBuilder.append((Integer.parseInt(String.valueOf(s.charAt(i - 1) + s.charAt(i))) % 10));
            }
            s = stringBuilder.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }
}