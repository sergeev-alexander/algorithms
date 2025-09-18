package sergeev.alexander.leetcode;

// 2414. Length of the Longest Alphabetical Continuous Substring
public class a2414 {

    /*
    An alphabetical continuous string is a string consisting of consecutive letters in the alphabet. In other words,
    it is any substring of the string "abcdefghijklmnopqrstuvwxyz".
    For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
    Given a string s consisting of lowercase letters only, return the length of the longest alphabetical continuous substring.
     */

    public static void main(String[] args) {
        String s = "aaaabcdaaaaa";
        System.out.println(longestContinuousSubstring(s));
    }

    // BEATS 19%
    public static int longestContinuousSubstring(String s) {
        if (s.length() == 1) return 1;

        int max = 0;
        int left = 0;
        int right = 1;
        int curr = 0;

        while (right < s.length()) {
            if (s.charAt(right - 1) + 1 == s.charAt(right)) {
                curr++;
                max = Math.max(max, curr);
            } else {
                max = Math.max(max, curr);
                curr = 0;
                left = right;
            }
            right++;
        }

        return max + 1;
    }
}