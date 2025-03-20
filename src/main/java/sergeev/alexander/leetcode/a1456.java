package sergeev.alexander.leetcode;

import java.util.Set;

// 1456. Maximum Number of Vowels in a Substring of Given Length
public class a1456 {

    /*
    Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
    Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
     */

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    // BEATS 99.82%
    public static int maxVowels(String s, int k) {
        int[] chars = new int[128];
        chars['a']++;
        chars['e']++;
        chars['i']++;
        chars['o']++;
        chars['u']++;
        int current = 0;
        for (int i = 0; i < k; i++) {
            current += chars[s.charAt(i)];
        }
        int max = current;
        for (int i = 0, j = k; j < s.length(); i++, j++) {
            current -= chars[s.charAt(i)];
            current += chars[s.charAt(j)];
            max = Math.max(max, current);
        }
        return max;
    }

    // BEATS 99.82%
    public static int maxVowels4(String s, int k) {
        int[] chars = new int[128];
        chars['a']++;
        chars['e']++;
        chars['i']++;
        chars['o']++;
        chars['u']++;
        char[] arr = s.toCharArray();
        int current = 0;
        for (int i = 0; i < k; i++) {
            current += chars[arr[i]];
        }
        int max = current;
        for (int i = 0, j = k; j < arr.length; i++, j++) {
            current -= chars[arr[i]];
            current += chars[arr[j]];
            max = Math.max(max, current);
        }
        return max;
    }

    // BEATS 99.20%
    public static int maxVowels3(String s, int k) {
        boolean[] chars = new boolean[128];
        chars['a'] = true;
        chars['e'] = true;
        chars['i'] = true;
        chars['o'] = true;
        chars['u'] = true;
        char[] arr = s.toCharArray();
        int current = 0;
        for (int i = 0; i < k; i++) {
            if (chars[arr[i]]) {
                current++;
            }
        }
        int max = current;
        for (int i = 0, j = k; j < arr.length; i++, j++) {
            if (chars[arr[i]]) {
                current--;
            }
            if (chars[arr[j]]) {
                current++;
            }
            max = Math.max(max, current);
        }
        return max;
    }

    // BEATS 18%
    public static int maxVowels2(String s, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        char[] arr = s.toCharArray();
        int max;
        int current = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(arr[i])) {
                current++;
            }
        }
        max = current;
        for (int i = 0, j = k; j < arr.length; i++, j++) {
            if (set.contains(arr[i])) {
                current--;
            }
            if (set.contains(arr[j])) {
                current++;
            }
            max = Math.max(max, current);
        }
        return max;
    }

    // TLE
    public static int maxVowels1(String s, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        char[] arr = s.toCharArray();
        int max = 0;
        for (int i = 0, j = k - 1; j < s.length(); i++, j++) {
            int count = 0;
            for (int l = i; l <= j; l++) {
                if (set.contains(arr[l])) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}