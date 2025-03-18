package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1408. String Matching in an Array
public class a1408 {

    /*
    Given an array of string words, return all strings in words that are a substring of another word.
    You can return the answer in any order.
     */

    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        System.out.println(stringMatching(words));
    }

    // BEATS 43%
    public static List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (words[i].contains(words[j])) {
                    set.add(words[j]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}