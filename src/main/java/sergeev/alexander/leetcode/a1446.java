package sergeev.alexander.leetcode;

// 1446. Consecutive Characters
public class a1446 {

    /*
    The power of the string is the maximum length of a non-empty substring that contains only one unique character.
    Given a string s, return the power of s.
     */

    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";
        System.out.println(maxPower(s));
    }

    // BEATS 99%
    public static int maxPower(String s) {
        int max = 1;
        int count = 0;
        char current = s.charAt(0);
        for (char ch : s.toCharArray()) {
            if (ch == current) count++;
            else {
                current = ch;
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}