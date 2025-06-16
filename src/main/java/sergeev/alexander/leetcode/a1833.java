package sergeev.alexander.leetcode;

import java.util.Arrays;

// 1833. Maximum Ice Cream Bars
public class a1833 {

    /*
    It is a sweltering summer day, and a boy wants to buy some ice cream bars.
    At the store, there are n ice cream bars. You are given an array costs of length n,
    where costs[i] is the price of the ith ice cream bar in coins.
    The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible.
    Note: The boy can buy the ice cream bars in any order.
    Return the maximum number of ice cream bars the boy can buy with coins coins.
    You must solve the problem by counting sort.
     */

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(arr, coins));
    }

    // BEATS 99%
    public static int maxIceCream(int[] costs, int coins) {
        int min = costs[0];
        int max = costs[0];

        for (int num : costs) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int dif = max - min + 1;
        int[] countArr = new int[dif];

        for (int num : costs) {
            countArr[num - min]++;
        }

        int count = 0;

        for (int i = 0; i < countArr.length; i++) {
            int currentPrice = i + min;
            if (coins - currentPrice < 0) {
                break;
            }
            while (countArr[i] > 0 && coins - currentPrice >= 0) {
                count++;
                coins -= currentPrice;
                countArr[i]--;
            }
        }

        return count;
    }

    // BEATS 65%
    public static int maxIceCream1(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int pos = 0;
        while (pos < costs.length && costs[pos] <= coins) {
            coins -= costs[pos++];
            count++;
        }
        return count;
    }
}