package sergeev.alexander.leetcode;

// 1550. Three Consecutive Odds
public class a1550 {

    /*
    Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,34,3,4,5,6,23,12};
        System.out.println(threeConsecutiveOdds(arr));
    }

    // BEATS 100%
    public static boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 2] % 2 != 0 && arr[i - 1] % 2 != 0 && arr[i] % 2 != 0) return true;
        }
        return false;
    }
}