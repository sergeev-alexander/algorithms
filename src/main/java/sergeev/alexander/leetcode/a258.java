package sergeev.alexander.leetcode;

//  258. Add Digits
public class a258 {

    /*
    Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
     */

    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }

    // BEATS 100%
    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}