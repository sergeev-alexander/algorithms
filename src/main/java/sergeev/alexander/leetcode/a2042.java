package sergeev.alexander.leetcode;

// 2042. Check if Numbers Are Ascending in a Sentence
public class a2042 {

    /*
    A sentence is a list of tokens separated by a single space with no leading or trailing spaces.
    Every token is either a positive number consisting of digits 0-9 with no leading zeros, or a word consisting of lowercase English letters.
    For example, "a puppy has 2 eyes 4 legs" is a sentence with seven tokens:
    "2" and "4" are numbers and the other tokens such as "puppy" are words.
    Given a string s representing a sentence,
    you need to check if all the numbers in s are strictly increasing from left to right
    (i.e., other than the last number, each number is strictly smaller than the number on its right in s).
    Return true if so, or false otherwise.
     */

    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        System.out.println(areNumbersAscending(s));
    }

    // BEATS 97%
    public static boolean areNumbersAscending(String s) {
        int min = -1;
        int num;
        for (String str : s.split(" ")) {
            if (str.length() == 1 && Character.isDigit(str.charAt(0))) {
                num = Character.getNumericValue(str.charAt(0));
                if (num > min) {
                    min = num;
                } else return false;
            }
            if (str.length() == 2 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(1))) {
                num = Integer.parseInt(str);
                if (num > min) {
                    min = num;
                } else return false;
            }
        }
        return true;
    }
}
