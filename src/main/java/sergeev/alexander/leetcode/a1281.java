package sergeev.alexander.leetcode;

// 1281. Subtract the Product and Sum of Digits of an Integer
public class a1281 {

    /*
    Given an integer number n, return the difference between the product of its digits and the sum of its digits.
     */

    public static void main(String[] args) {
        int num = 234;
        System.out.println(subtractProductAndSum(num));
    }

    // BEATS 100%
    public static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            product *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return product - sum;
    }
}
