package sergeev.alexander.leetcode;

// 1614. Maximum Nesting Depth of the Parentheses
public class a1614 {

    /*
    Given a valid parentheses string s, return the nesting depth of s.
    The nesting depth is the maximum number of nested parentheses.
     */

    public static void main(String[] args) {
        String s = "()(())((()()))";
        System.out.println(maxDepth(s));
    }

    // BEATS 100%
    public static int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
                max = Math.max(max, count);
            }
            if (ch == ')') {
                count--;
            }
        }
        return max;
    }
}