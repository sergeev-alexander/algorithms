package sergeev.alexander.leetcode;

// 3110. Score of a String
public class a3110 {

    /*
    You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
    Return the score of s.
     */

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(scoreOfString(str));
    }

    // BEATS 99%
    public static int scoreOfString(String s) {
        int sum = 0;

        for (int i = 1; i < s.length(); i++) {
            sum += Math.abs(s.charAt(i - 1) - s.charAt(i));
        }

        return sum;
    }
}
