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
        String s = "abacaba";
        System.out.println(longestContinuousSubstring(s));
    }

    // BEATS 13%
    public static int longestContinuousSubstring(String s) {
        if (s.length() == 1) return 1;

        int max = 0;
        int curr = 0;
        int pos = 0;
        while (pos < s.length() - 1) {
            while (s.charAt(pos) + 1 == s.charAt(++pos)) {
                curr++;
            }
            max = Math.max(max, curr);
            curr = 0;
        }

        return max + 1;
    }

    // BEATS 43%
    public static int longestContinuousSubstring1(String s) {
        if (s.length() == 1) return 1;

        int max = 0;
        int currPos = 1;
        int currStreak = 0;

        while (currPos < s.length()) {
            if (s.charAt(currPos - 1) + 1 == s.charAt(currPos)) {
                currStreak++;
                max = Math.max(max, currStreak);
            } else {
                max = Math.max(max, currStreak);
                currStreak = 0;
            }
            currPos++;
        }

        return max + 1;
    }
}