package sergeev.alexander.leetcode;

import java.util.HashSet;
import java.util.Set;

// 1346. Check If N and Its Double Exist
public class a1346 {

    /*
    Given an array arr of integers, check if there exist two indices i and j such that :
    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]
     */

    public static void main(String[] args) {
        int[] arr = {0,0};
        System.out.println(checkIfExist(arr));
    }

    // BEATS 94%
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) return true;
            set.add(num);
        }
        return false;
    }
}
