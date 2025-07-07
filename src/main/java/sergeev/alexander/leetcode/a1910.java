package sergeev.alexander.leetcode;

// 1910. Remove All Occurrences of a Substring
public class a1910 {

    /*
    Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
    Find the leftmost occurrence of the substring part and remove it from s.
    Return s after removing all occurrences of part.
    A substring is a contiguous sequence of characters in a string.
     */

    public static void main(String[] args) {
        String s = "abcabcccc";
        String p = "abc";
        System.out.println(removeOccurrences(s,p));
    }

    // BEATS 99%
    public static String removeOccurrences(String s, String part) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int index = stringBuilder.indexOf(part);

        while (index >= 0) {
            stringBuilder.replace(index, index + part.length(), "");
            index = stringBuilder.indexOf(part);
        }

        return stringBuilder.toString();
    }
}