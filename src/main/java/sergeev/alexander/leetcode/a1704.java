package sergeev.alexander.leetcode;

import java.util.Set;

// 1704. Determine if String Halves Are Alike
public class a1704 {

    /*
    You are given a string s of even length.
    Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
    Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
    Notice that s contains uppercase and lowercase letters.
    Return true if a and b are alike. Otherwise, return false.
     */

    public static void main(String[] args) {
        String s = "book";
        System.out.println(halvesAreAlike(s));
    }

    // BEATS 93%
    public static boolean halvesAreAlike(String s) {
        int vowels = 1 << 'a' | 1 << 'e' | 1 << 'i' | 1 << 'o' | 1 << 'u' |
                1 << 'A' | 1 << 'E' | 1 << 'I' | 1 << 'O' | 1 << 'U';
        int n = s.length(), half = n / 2;
        int count = 0;
        for (int i = 0; i < half; i++) {
            count += (vowels & (1 << s.charAt(i))) != 0 ? 1 : 0;
        }
        for (int i = half; i < n; i++) {
            count -= (vowels & (1 << s.charAt(i))) != 0 ? 1 : 0;
        }
        return count == 0;
    }

    // BEATS 93%
    public static boolean halvesAreAlike2(String s) {
        boolean[] arr = new boolean[123];
        arr['a'] = true;
        arr['e'] = true;
        arr['i'] = true;
        arr['o'] = true;
        arr['u'] = true;
        arr['A'] = true;
        arr['E'] = true;
        arr['I'] = true;
        arr['O'] = true;
        arr['U'] = true;
        int n = s.length();
        int firstHalfCount = 0;
        int secondHalfCount = 0;
        for (int i = 0, j = n / 2; j < n; i++, j++) {
            if (arr[s.charAt(i)]) firstHalfCount++;
            if (arr[s.charAt(j)]) secondHalfCount++;
        }
        return firstHalfCount == secondHalfCount;
    }

    // BEATS 49%
    public static boolean halvesAreAlike1(String s) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int n = s.length();
        int firstHalfCount = 0;
        int secondHalfCount = 0;
        for (int i = 0, j = n / 2; j < n; i++, j++) {
            if (set.contains(s.charAt(i))) firstHalfCount++;
            if (set.contains(s.charAt(j))) secondHalfCount++;
        }
        return firstHalfCount == secondHalfCount;
    }
}