package sergeev.alexander;

public class Temp {

    public static void main(String[] args) {
        String firstWord = "aaa", secondWord = "a", targetWord = "aab";
        System.out.println(isSumEqual(firstWord, secondWord, targetWord));
    }

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