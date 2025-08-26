package sergeev.alexander.leetcode;

// 2169. Count Operations to Obtain Zero
public class a2169 {

    /*
    You are given two non-negative integers num1 and num2.
    In one operation, if num1 >= num2, you must subtract num2 from num1, otherwise subtract num1 from num2.
    For example, if num1 = 5 and num2 = 4, subtract num2 from num1, thus obtaining num1 = 1 and num2 = 4.
    However, if num1 = 4 and num2 = 5, after one operation, num1 = 4 and num2 = 1.
    Return the number of operations required to make either num1 = 0 or num2 = 0.
     */

    public static void main(String[] args) {
        int num1 = 2, num2 = 3;
        System.out.println(countOperations(num1,num2));
    }

    // BEATS 100%
    public static int countOperations(int num1, int num2) {
        int count = 0;

        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                count += num1 / num2;
                num1 %= num2;
            } else {
                count += num2 / num1;
                num2 %= num1;
            }
        }

        return count;
    }

    // BEATS 92%
    public static int countOperations1(int num1, int num2) {
        int count = 0;

        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }

        return count;
    }
}