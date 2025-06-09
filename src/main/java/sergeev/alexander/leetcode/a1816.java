package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1816. Truncate Sentence
public class a1816 {

    /*
    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    Each of the words consists of only uppercase and lowercase English letters (no punctuation).
    For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
    You are given a sentence s and an integer k. You want to truncate s such that it contains only the first k words.
    Return s after truncating it.
     */

    public static void main(String[] args) {
        String s = "What is the solution to this problem";
        int k = 4;
        System.out.println(truncateSentence(s,k));
    }

    // BEATS 100%
    public static String truncateSentence(String s, int k) {
        int wordsCount = 0;
        int index = 0;
        while (index < s.length() && wordsCount < k) {
            if (s.charAt(index) == ' ') {
                wordsCount++;
            }
            index++;
        }
        return wordsCount == k ? s.substring(0, index - 1) : s;
    }

    // BEATS 77%
    public static String truncateSentence3(String s, int k) {
        String[] arr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(arr[i]);
            if (i < k - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    // BEATS 77%
    public static String truncateSentence2(String s, int k) {
        String[] arr = s.split(" ");
        String[] result = new String[k];
        if (arr.length <= k) {
            return s;
        } else {
            System.arraycopy(arr, 0, result, 0, k);
        }
        return String.join(" ", result);
    }

    // BEATS 44%
    public static String truncateSentence1(String s, int k) {
        return String.join(" ", Arrays.copyOf(s.split(" "), k));
    }
}