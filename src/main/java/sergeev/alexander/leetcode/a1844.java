package sergeev.alexander.leetcode;

// 1844. Replace All Digits with Characters
public class a1844 {

    /*
    You are given a 0-indexed string s that has lowercase English letters in its even indices and digits in its odd indices.
    You must perform an operation shift(c, x), where c is a character and x is a digit, that returns the xth character after c.
    For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
    For every odd index i, you want to replace the digit s[i] with the result of the shift(s[i-1], s[i]) operation.
    Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i]) will never exceed 'z'.
    Note that shift(c, x) is not a preloaded function, but an operation to be implemented as part of the solution.
     */

    public static void main(String[] args) {
        String s = "a1b2c3d4e";
        System.out.println(replaceDigits(s));
    }

    // BEATS 100%
    public static String replaceDigits(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < s.length(); i += 2) {
            char firstChar = s.charAt(i - 1);
            int shift = s.charAt(i) - '0';
            char secondChar = (char) (firstChar + shift);
            stringBuilder
                    .append(firstChar)
                    .append(secondChar);
        }

        if (s.length() % 2 != 0) {
            stringBuilder.append(s.charAt(s.length() - 1));
        }

        return stringBuilder.toString();
    }
}