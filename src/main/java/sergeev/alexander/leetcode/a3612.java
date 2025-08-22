package sergeev.alexander.leetcode;

// 3612. Process String with Special Operations I
public class a3612 {

    /*
    You are given a string s consisting of lowercase English letters and the special characters: *, #, and %.
    Build a new string result by processing s according to the following rules from left to right:
    If the letter is a lowercase English letter append it to result.
    A '*' removes the last character from result, if it exists.
    A '#' duplicates the current result and appends it to itself.
    A '%' reverses the current result.
    Return the final string result after processing all characters in s.
     */

    public static void main(String[] args) {
        String s = "a#b%*";
        System.out.println(processStr(s));
    }

    // BEATS 100%
    public static String processStr(String s) {
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

        return result.toString();
    }
}