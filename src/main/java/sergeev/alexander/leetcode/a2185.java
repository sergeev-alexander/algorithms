package sergeev.alexander.leetcode;

// 2185. Counting Words With a Given Prefix
public class a2185 {

    /*
    You are given an array of strings words and a string pref.
    Return the number of strings in words that contain pref as a prefix.
    A prefix of a string s is any leading contiguous substring of s.
     */

    public static void main(String[] args) {
        String[] arr = {"pay","attention","practice","attend"};
        String prefix = "at";
        System.out.println(prefixCount(arr, prefix));
    }

    // BEATS 100%
    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) count++;
        }
        return count;
    }

    // BEATS 30%
    public static int prefixCount1(String[] words, String pref) {
        int count = 0;

        for (String s : words) {
            if (s.length() >= pref.length()) {
                if (s.substring(0, pref.length()).equals(pref)) {
                    count++;
                }
            }
        }

        return count;
    }

    // BEATS 11%
    public static int prefixCount2(String[] words, String pref) {
        int count = 0;

        MARK:
        for (String s : words) {
            if (s.length() >= pref.length()) {

                for (int i = 0; i < pref.length(); i++) {
                    if (pref.charAt(i) != s.charAt(i)) continue MARK;
                }

                count++;
            }
        }

        return count;
    }
}