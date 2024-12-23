package sergeev.alexander.leetcode;

// 125. Valid Palindrome
public class a125 {

    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
    all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include
    letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.
     */

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));


    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }


    public static boolean isPalindromeSLOW_WITH_FOR(String s) {
        String str = (s.replaceAll("[\\W\\p{Punct}]", "")).toLowerCase();
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }

    public static boolean isPalindrome_SLOW(String s) {
        String a = (s.replaceAll("[\\W\\p{Punct}]", ""));
        return a.equalsIgnoreCase(new StringBuilder(a).reverse().toString());
    }
}
