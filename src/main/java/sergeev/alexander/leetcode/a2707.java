package sergeev.alexander.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 2707. Extra Characters in a String
public class a2707 {

    /*
    You are given a 0-indexed string s and a dictionary of words dictionary.
    You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary.
    There may be some extra characters in s which are not present in any of the substrings.
    Return the minimum number of extra characters left over if you break up s optimally.
     */

    public static void main(String[] args) {
        String s = "dwmodizxvvbosxxw";
        String[] d = {"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"};
        System.out.println(minExtraChar(s, d));
    }

    // BEATS 61%
    public static int minExtraChar(String s, String[] dictionary) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        int[] minExtraChars = new int[n + 1];
        minExtraChars[0] = 0;
        for (int i = 1; i <= n; ++i) {
            minExtraChars[i] = minExtraChars[i - 1] + 1;
            for (int j = 0; j < i; ++j) {
                if (wordSet.contains(s.substring(j, i))) {
                    minExtraChars[i] = Math.min(minExtraChars[i], minExtraChars[j]);
                }
            }
        }
        return minExtraChars[n];
    }
}