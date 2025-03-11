package sergeev.alexander.leetcode;

// 9. Palindrome Number
public class a09 {

    /*
    Given an integer x, return true if x is a palindrome, and false otherwise.
     */

    public static void main(String[] args) {
        int num = 101;
        System.out.println(isPalindrome(num));
    }

    // BEATS 100%
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }

    // BEATS 29%
    public static boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int size = (int) Math.log10(x);
        if (size == 0) return true;
        while (size >= 1) {
            int a = (int) Math.pow(10, size);
            int left = x / a;
            int right = x % 10;
            if (left != right) return false;
            x %= a;
            x /= 10;
            size -= 2;
        }
        return true;
    }
}
