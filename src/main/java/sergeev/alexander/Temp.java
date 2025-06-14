package sergeev.alexander;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Temp {

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(arr, coins));
    }

    // BEATS 65%
    public static int maxIceCream(int[] costs, int coins) {
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