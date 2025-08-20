package sergeev.alexander.leetcode;

import java.util.HashSet;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class a3 {

    /*
    Given a string s, find the length of the longest substring without duplicate characters.
     */

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    // BEATS 98%
    public static int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];

        if (!s.isEmpty()) {
            arr[s.charAt(0)]++;
        } else return 0;

        int left = 0;
        int right = 1;
        int max = 1;
        int count = 1;

        while (left < s.length() && right < s.length()) {
            if (arr[s.charAt(right)] == 0) {
                arr[s.charAt(right)]++;
                count++;
                right++;
            } else {
                arr[s.charAt(left++)]--;
                count--;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    // BETAS 73%
    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();

        if (!s.isEmpty()) {
            set.add(s.charAt(0));
        } else return 0;

        int left = 0;
        int right = 1;
        int max = 1;

        while (left < s.length() && right < s.length()) {
            if (set.add(s.charAt(right))) {
                max = Math.max(max, set.size());
                right++;
            } else {
                set.remove(s.charAt(left++));
            }
        }

        return max;
    }
}