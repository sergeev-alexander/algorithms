package sergeev.alexander.leetcode;

// 3216. Lexicographically Smallest String After a Swap
public class a3216 {

    /*
    Given a string s containing only digits,
    return the lexicographically smallest string that can be obtained after swapping adjacent digits in s with the same parity at most once.
    Digits have the same parity if both are odd or both are even. For example, 5 and 9, as well as 2 and 4, have the same parity,
    while 6 and 9 do not.
     */

    public static void main(String[] args) {
        String s = "45320";
        System.out.println(getSmallestString(s));
    }

    // BEATS 100%
    public static String getSmallestString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0; i < s.length() - 1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            if (ch1 > ch2 && ch1 % 2 == ch2 % 2) {
                stringBuilder.setCharAt(i, ch2);
                stringBuilder.setCharAt(i + 1, ch1);
                break;
            }
        }

        return stringBuilder.toString();
    }
}