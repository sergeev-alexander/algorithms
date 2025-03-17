package sergeev.alexander.leetcode;

// 1390. Four Divisors
public class a1390 {

    /*
    Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
    If there is no such integer in the array, return 0.
     */

    public static void main(String[] args) {
        int[] nums = {21,4,7};
        System.out.println(sumFourDivisors(nums));
    }

    // BEATS 58%
    public static int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int count = 2;
            int sum = num + 1;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    count++;
                    sum += i;
                    if (i * i != num) {
                        count++;
                        sum += num / i;
                    }
                }
            }
            if (count == 4) {
                result += sum;
            }
        }
        return result;
    }
}