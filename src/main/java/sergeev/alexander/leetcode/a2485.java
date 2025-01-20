package sergeev.alexander.leetcode;

// 2485. Find the Pivot Integer
public class a2485 {

    /*
    Given a positive integer n, find the pivot integer x such that:
    The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
    Return the pivot integer x. If no such integer exists, return -1.
    It is guaranteed that there will be at most one pivot index for the given input.
     */

    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    // BEATS 100%
    public static int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int sqrt = (int) Math.sqrt(sum);
        if (Math.pow(sqrt, 2) == sum) return sqrt;
        else return -1;
    }

    // BEATS 9%
    public static int pivotInteger1(int n) {
        for (int i = 1; i <= n; i++) {
            int prefixSum = 0;
            int sufixSum = 0;
            for (int j = 1; j <= i; j++) {
                prefixSum += j;
            }
            for (int j = i; j <= n; j++) {
                sufixSum += j;
            }
            if (prefixSum == sufixSum) return i;
        }
        return -1;
    }
}