package sergeev.alexander.leetcode;

// 1460. Make Two Arrays Equal by Reversing Subarrays
public class a1460 {

    /*
    You are given two integer arrays of equal length target and arr.
    In one step, you can select any non-empty subarray of arr and reverse it.
    You are allowed to make any number of steps.
    Return true if you can make arr equal to target or false otherwise.
     */

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4};
        int[] a2 = {2,4,1,3};
        System.out.println(canBeEqual(a1, a2));
    }

    // BEATS 99.32%
    public static boolean canBeEqual(int[] target, int[] arr) {
        int[] array = new int[1_001];
        for (int num : target) {
            array[num]++;
        }
        for (int num : arr) {
            array[num]--;
        }
        for (int num : array) {
            if (num != 0) return false;
        }
        return true;
    }
}