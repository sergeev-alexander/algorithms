package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

// 1451. Rearrange Words in a Sentence
public class a1451 {

    /*
    Given a sentence text (A sentence is a string of space-separated words) in the following format:
    First letter is in upper case.
    Each word in text are separated by a single space.
    Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths.
    If two words have the same length, arrange them in their original order.
    Return the new text following the format shown above.
     */

    public static void main(String[] args) {
        String s = "Keep calm and code on";
        System.out.println(arrangeWords(s));
    }

    // BEATS 92%
    public static String arrangeWords(String text) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : text.split(" ")) {
            s = s.toLowerCase();
            map.computeIfAbsent(s.length(), v -> new ArrayList<>()).add(s);
        }
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (List<String> list : map.values()) {
            for (String s : list) {
                stringJoiner.add(s);
            }
        }
        return stringJoiner.toString().substring(0, 1).toUpperCase() + stringJoiner.toString().substring(1);
    }

    // BEATS 89%
    public static String arrangeWords1(String text) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (String s : text.split(" ")) {
            s = s.toLowerCase();
            map.computeIfAbsent(s.length(), v -> new ArrayList<>()).add(s);
        }
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (List<String> list : map.values()) {
            for (String s : list) {
                stringJoiner.add(s);
            }
        }
        return stringJoiner.toString().substring(0, 1).toUpperCase() + stringJoiner.toString().substring(1);
    }
}