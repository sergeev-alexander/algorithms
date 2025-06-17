package sergeev.alexander.leetcode;

// 1876. Substrings of Size Three with Distinct Characters
public class a1876 {

    /*
    A string is good if there are no repeated characters.
    Given a string s, return the number of good substrings of length three in s.
    Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
    A substring is a contiguous sequence of characters in a string.
     */

    public static void main(String[] args) {
        String s = "aababcabc";
        System.out.println(countGoodSubstrings(s));
    }

    // BEATS 100%
    public static int countGoodSubstrings(String s) {
        int count = 0;

        for (int i = 3; i <= s.length(); i++) {
            char one = s.charAt(i - 3);
            char two = s.charAt(i - 2);
            char three = s.charAt(i - 1);
            if (one != two && one != three && two != three) count++;
        }

        return count;
    }

    // BEATS 87%
    public static int countGoodSubstrings1(String s) {
        int count = 0;

        for (int i = 3; i <= s.length(); i++) {
            if (isValid(s.substring(i - 3, i))) count++;
        }

        return count;
    }

    public static boolean isValid(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a']++ > 0) return false;
        }
        return true;
    }
}