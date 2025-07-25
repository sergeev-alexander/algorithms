package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1859. Sorting the Sentence
public class a1859 {

    /*
    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    Each word consists of lowercase and uppercase English letters.
    A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
    For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
    Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
     */

    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }

    // BEATS 100%
    public static String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] result = new String[arr.length];

        for (String str : arr) {
            result[str.charAt(str.length() - 1) - '1'] = str.substring(0, str.length() - 1);
        }

        return String.join(" ", result);
    }
}
