package sergeev.alexander.leetcode;

// 3614. Process String with Special Operations II
public class a3614 {

    /*
    You are given a string s consisting of lowercase English letters and the special characters: '*', '#', and '%'.
    You are also given an integer k.
    Build a new string result by processing s according to the following rules from left to right:
    If the letter is a lowercase English letter append it to result.
    A '*' removes the last character from result, if it exists.
    A '#' duplicates the current result and appends it to itself.
    A '%' reverses the current result.
    Return the kth character of the final string result. If k is out of the bounds of result, return '.'.
     */

    public static void main(String[] args) {
        String s = "%#bz%xum##i##vzo#pwc*#dkwbh####%uf%s*%cgppqhqa%h#l##o%ij%%cz%iga##e###u%#e####jfwx##%%*x%m*%#";
        long k = 6523L;
        System.out.println(processStr(s, k));
    }

    // TLE
    public static char processStr(String s, long k) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '*' -> {
                    if (!result.isEmpty()) {
                        result.deleteCharAt(result.length() - 1);
                    }
                }
                case '#' -> result.append(result);
                case '%' -> result.reverse();
                default -> result.append(ch);
            }
        }

        if (k >= result.length() || result.isEmpty()) {
            return '.';
        } else {
            return result.charAt((int) k);
        }
    }
}