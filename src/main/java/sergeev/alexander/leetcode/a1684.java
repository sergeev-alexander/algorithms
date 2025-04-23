package sergeev.alexander.leetcode;

// 1684. Count the Number of Consistent Strings
public class a1684 {

    /*
    You are given a string allowed consisting of distinct characters and an array of strings words.
    A string is consistent if all characters in the string appear in the string allowed.
    Return the number of consistent strings in the array words.
     */

    public static void main(String[] args) {
        String[] arr = {"ad","bd","aaab","baa","badab"};
        String s = "ab";
        System.out.println(countConsistentStrings(s,arr));
    }

    // BEATS 88%
    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        boolean[] arr = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            arr[ch - 'a'] = true;
        }
        MARK:
        for (String s : words) {
            for (char ch : s.toCharArray()) {
                if (!arr[ch - 'a']) {
                    continue MARK;
                }
            }
            count++;
        }
        return count;
    }

    // BEATS 88%
    public static int countConsistentStrings1(String allowed, String[] words) {
        int count = 0;
        int[] arr = new int[26];
        for (char ch : allowed.toCharArray()) {
            arr[ch - 'a']++;
        }
        MARK:
        for (String s : words) {
            for (char ch : s.toCharArray()) {
                if (arr[ch - 'a'] == 0) {
                    continue MARK;
                }
            }
            count++;
        }
        return count;
    }
}
