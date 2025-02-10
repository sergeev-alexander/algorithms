package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.Map;

// 290. Word Pattern
public class a290 {

    /*
    Given a pattern and a string s, find if s follows the same pattern.
    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
    Specifically:
    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.
     */

    public static void main(String[] args) {
        String p = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern(p, s));
    }

    // BEATS 82%
    public static boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (strings.length != chars.length) return false;
        Map<String, Character> map1 = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map1.containsKey(strings[i])) {
                map1.put(strings[i], chars[i]);
            }
            if (!map2.containsKey(chars[i])) {
                map2.put(chars[i], strings[i]);
            }
            if (map1.get(strings[i]) != chars[i] || !map2.get(chars[i]).equals(strings[i])) return false;
        }
        return true;
    }
}