package sergeev.alexander.leetcode;

// 242. Valid Anagram
public class a242 {

    /*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     */

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    // BEATS 99%
    public static boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            arr[ch - 'a']--;
            if (arr[ch - 'a'] < 0) return false;
        }
        for (int i : arr) {
            if (i != 0) return false;
        }
        return true;
    }
}