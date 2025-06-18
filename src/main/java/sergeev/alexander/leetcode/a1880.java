package sergeev.alexander.leetcode;

// 1880. Check if Word Equals Summation of Two Words
public class a1880 {

    /*
    The letter value of a letter is its position in the alphabet starting from 0 (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, etc.).
    The numerical value of some string of lowercase English letters s is the concatenation of the letter values of each letter in s,
    which is then converted into an integer.
    For example, if s = "acb", we concatenate each letter's letter value, resulting in "021". After converting it, we get 21.
    You are given three strings firstWord, secondWord, and targetWord, each consisting of lowercase English letters 'a' through 'j' inclusive.
    Return true if the summation of the numerical values of firstWord and secondWord equals the numerical value of targetWord, or false otherwise.
     */

    public static void main(String[] args) {
        String firstWord = "aaa", secondWord = "a", targetWord = "aab";
        System.out.println(isSumEqual(firstWord, secondWord, targetWord));
    }

    // BEATS 100%
    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int firstSum = 0;

        for (int i = firstWord.length() - 1, j = 1; i >= 0; i--, j *= 10) {
            firstSum += (firstWord.charAt(i) - 'a') * j;
        }

        int secondSum = 0;

        for (int i = secondWord.length() - 1, j = 1; i >= 0; i--, j *= 10) {
            secondSum += (secondWord.charAt(i) - 'a') * j;
        }

        int targetSum = 0;

        for (int i = targetWord.length() - 1, j = 1; i >= 0; i--, j *= 10) {
            targetSum += (targetWord.charAt(i) - 'a') * j;
        }

        return (firstSum + secondSum) == targetSum;
    }
}