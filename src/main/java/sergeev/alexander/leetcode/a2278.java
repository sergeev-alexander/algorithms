package sergeev.alexander.leetcode;

// 2278. Percentage of Letter in String
public class a2278 {

    /*
    Given a string s and a character letter, return the percentage of characters in s that equal letter rounded down to the nearest whole percent.
     */

    public static void main(String[] args) {
        String s = "foobar";
        char ch = 'o';
        System.out.println(percentageLetter(s, ch));
    }

    // BEATS 100%
    public static int percentageLetter(String s, char letter) {
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == letter) count++;
        }

        return (int) ((double) count / s.length() * 100);
    }
}