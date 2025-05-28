package sergeev.alexander.leetcode;

// 1768. Merge Strings Alternately
public class a1768 {

    /*
    You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
    starting with word1. If a string is longer than the other,
    append the additional letters onto the end of the merged string.
    Return the merged string.
     */

    public static void main(String[] args) {
        String s1 = "aaaa";
        String s2 = "ssssssssss";
        System.out.println(mergeAlternately(s1, s2));
    }

    // BEATS 81%
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 0; i < Math.max(word1.length(), word2.length()); i++, j++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (j < word2.length()) {
                sb.append(word2.charAt(j));
            }
        }

        return sb.toString();
    }

    // BEATS 81%
    public String mergeAlternately1(String word1, String word2) {
        int pos1 = 0;
        int pos2 = 0;
        char[] arr = new char[word1.length() + word2.length()];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (pos1 < word1.length()) {
                    arr[i] = word1.charAt(pos1++);
                } else {
                    arr[i] = word2.charAt(pos2++);
                }
            } else {
                if (pos2 < word2.length()) {
                    arr[i] = word2.charAt(pos2++);
                } else {
                    arr[i] = word1.charAt(pos1++);
                }
            }
        }

        return new String(arr);
    }
}
