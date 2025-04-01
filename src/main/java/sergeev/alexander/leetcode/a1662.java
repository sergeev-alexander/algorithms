package sergeev.alexander.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 1662. Check If Two String Arrays are Equivalent
public class a1662 {

    /*
    Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
    A string is represented by an array if the array elements concatenated in order forms the string.
     */

    public static void main(String[] args) {
        String[] arr1 = {"ab", "c"};
        String[] arr2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(arr1, arr2));
    }

    // BEATS 100%
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String s : word1) sb1.append(s);
        StringBuilder sb2 = new StringBuilder();
        for (String s : word2) sb2.append(s);
        return sb1.toString().equals(sb2.toString());
    }

    // BEATS 13%
    public static boolean arrayStringsAreEqual4(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String s : word1) sb1.append(s);
        StringBuilder sb2 = new StringBuilder();
        for (String s : word2) sb2.append(s);
        if (sb1.length() != sb2.length()) return false;
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) return false;
        }
        return true;
    }

    // BEATS 59%
    public static boolean arrayStringsAreEqual3(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String s : word1) sb1.append(s);
        StringBuilder sb2 = new StringBuilder();
        for (String s : word2) sb2.append(s);
        return sb1.toString().contentEquals(sb2);
    }

    // BEATS 2%
    public static boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        return Arrays.stream(word1)
                .flatMap(s -> Stream.of(s.split("")))
                .collect(Collectors.joining())
                .equals(Arrays.stream(word2)
                        .flatMap(s -> Stream.of(s.split("")))
                        .collect(Collectors.joining()));
    }

    // BEATS 59%
    public static boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}