package sergeev.alexander.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 824. Goat Latin
public class a824 {

    /*
    You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.
    We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:
    If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
    For example, the word "apple" becomes "applema".
    If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
    For example, the word "goat" becomes "oatgma".
    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
    Return the final sentence representing the conversion from sentence to Goat Latin.
     */

    public static void main(String[] args) {
        String sentence = "I speak Goat Latin";
        System.out.println(toGoatLatin(sentence));
    }

    // BEATS 82%
    public static String toGoatLatin(String sentence) {
        String maEnding = "ma";
        StringBuilder aEnding = new StringBuilder("a");
        String[] arr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        for (String word : arr) {
            char ch = word.charAt(0);
            if (set.contains(ch)) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(ch);
            }
            result.append(maEnding).append(aEnding).append(" ");
            aEnding.append('a');
        }

        return result.substring(0, result.length() - 1);
    }
}