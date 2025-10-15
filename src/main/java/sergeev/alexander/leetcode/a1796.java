package sergeev.alexander.leetcode;

// 1796. Second Largest Digit in a String
public class a1796 {

    /*
    Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
    An alphanumeric string is a string consisting of lowercase English letters and digits.
     */

    public static void main(String[] args) {
        String s = "dfa077afd";
        System.out.println(secondHighest(s));
    }

    // BEATS 100%
    public static int secondHighest(String s) {
        int count = 1;

        for (char ch = '9'; ch >= '0'; ch--) {

            if (s.indexOf(ch) != -1) {

                if (count == 0) {
                    return ch - '0';
                } else count--;
            }
        }

        return -1;
    }

    // BEATS 95%
    public static int secondHighest2(String s) {
        int firstLargest = -1;
        int secondLargest = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                int num = ch - '0';

                if (num > firstLargest) {
                    secondLargest = firstLargest;
                    firstLargest = num;
                } else if (num > secondLargest && num != firstLargest) {
                    secondLargest = num;
                }
            }
        }

        return secondLargest;
    }

    // BEATS 60%
    public static int secondHighest1(String s) {
        int firstLargest = -1;
        int secondLargest = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int num = Character.getNumericValue(ch);

                if (num > firstLargest) {
                    secondLargest = firstLargest;
                    firstLargest = num;
                } else if (num > secondLargest && num != firstLargest) {
                    secondLargest = num;
                }
            }
        }

        return secondLargest;
    }
}