package sergeev.alexander.leetcode;

// 1342. Number of Steps to Reduce a Number to Zero
public class a1342 {

    /*
    Given an integer num, return the number of steps to reduce it to zero.
    In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
     */

    public static void main(String[] args) {
        int num = 123;
        System.out.println(numberOfSteps(num));
    }

    // BEATS 100%
    public static int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }
}