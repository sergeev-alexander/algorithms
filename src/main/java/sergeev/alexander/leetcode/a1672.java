package sergeev.alexander.leetcode;

// 1672. Richest Customer Wealth
public class a1672 {

    /*
    You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i-th customer has in the j-th bank.
    Return the wealth that the richest customer has.
    A customer's wealth is the amount of money they have in all their bank accounts.
    The richest customer is the customer that has the maximum wealth.
     */

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(maximumWealth(mat));
    }

    // BEATS 100%
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}