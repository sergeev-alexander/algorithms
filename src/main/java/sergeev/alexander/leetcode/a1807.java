package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1807. Evaluate the Bracket Pairs of a String
public class a1807 {

    /*
    You are given a string s that contains some bracket pairs, with each pair containing a non-empty key.
    For example, in the string "(name)is(age)yearsold", there are two bracket pairs that contain the keys "name" and "age".
    You know the values of a wide range of keys.
    This is represented by a 2D string array knowledge where each knowledge[i] = [keyi, valuei] indicates that key keyi has a value of valuei.
    You are tasked to evaluate all of the bracket pairs. When you evaluate a bracket pair that contains some key keyi, you will:
    Replace keyi and the bracket pair with the key's corresponding valuei.
    If you do not know the value of the key, you will replace keyi and the bracket pair with a question mark "?" (without the quotation marks).
    Each key will appear at most once in your knowledge. There will not be any nested brackets in s.
    Return the resulting string after evaluating all of the bracket pairs.
     */

    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        List<List<String>> list = List.of(List.of("name", "bob"), List.of("age", "two"));
        System.out.println(evaluate(s, list));
    }

    // BEATS 67%
    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                StringBuilder sb = new StringBuilder();
                while (s.charAt(++i) != ')') {
                    sb.append(s.charAt(i));
                }
                stringBuilder.append(map.getOrDefault(sb.toString(), "?"));
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}