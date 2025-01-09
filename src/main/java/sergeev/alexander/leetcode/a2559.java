package sergeev.alexander.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 2559. Count Vowel Strings in Ranges
public class a2559 {

    /*
    You are given a 0-indexed array of strings words and a 2D array of integers queries.
    Each query queries[i] = [li, ri] asks us to find the number of strings present
    in the range li to ri (both inclusive) of words that start and end with a vowel.
    Return an array ans of size queries.length, where ans[i] is the answer to the ith query.
    Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.
     */

    public static void main(String[] args) {
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    // BEATS 99%
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        boolean[] isRightWordArr = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isVowel(words[i])) {
                isRightWordArr[i] = true;
                count++;
            }
        }
        int[] prefixArr = new int[n + 1];
        int prefixSum = 0;
        for (int i = 1; i < n + 1; i++) {
            if (isRightWordArr[i - 1]) {
                prefixSum++;
            }
            prefixArr[i] = prefixSum;
        }
        int[] suffixArr = new int[n + 1];
        int suffixSum = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (isRightWordArr[i + 1]) {
                suffixSum++;
            }
            suffixArr[i] = suffixSum;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = count - prefixArr[queries[i][0]] - suffixArr[queries[i][1]];
        }
        return result;
    }

    private static boolean isVowel(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return (first == 'a'
                || first == 'e'
                || first == 'i'
                || first == 'o'
                || first == 'u')
                &&
                (last == 'a'
                        || last == 'e'
                        || last == 'i'
                        || last == 'o'
                        || last == 'u');
    }

    // BEATS 40%
    public static int[] vowelStrings1(String[] words, int[][] queries) {
        int n = words.length;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        boolean[] isRightWordArr = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) {
                isRightWordArr[i] = true;
                count++;
            }
        }
        int[] prefixArr = new int[n + 1];
        int prefixSum = 0;
        for (int i = 1; i < n + 1; i++) {
            if (isRightWordArr[i - 1]) {
                prefixSum++;
            }
            prefixArr[i] = prefixSum;
        }
        int[] suffixArr = new int[n + 1];
        int suffixSum = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (isRightWordArr[i + 1]) {
                suffixSum++;
            }
            suffixArr[i] = suffixSum;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = count - prefixArr[left] - suffixArr[right];
        }
        return result;
    }
}