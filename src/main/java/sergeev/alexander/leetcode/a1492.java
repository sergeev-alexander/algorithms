package sergeev.alexander.leetcode;

// 1492. The kth Factor of n
public class a1492 {

    /*
    You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
    Consider a list of all factors of n sorted in ascending order,
    return the kth factor in this list or return -1 if n has less than k factors.
     */

    public static void main(String[] args) {
        int n = 12;
        int k = 3;
        System.out.println(kthFactor(n,k));
    }

    // BEATS 100%
    public static int kthFactor(int n, int k) {
        int num = 1;
        while (num <= n && k >= 0) {
            if (n % num == 0) {
                k--;
            }
            if (k == 0) return num;
            num++;
        }
        return -1;
    }
}