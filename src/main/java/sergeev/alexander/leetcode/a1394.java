package sergeev.alexander.leetcode;

// 1394. Find Lucky Integer in an Array
public class a1394 {

    /*
    Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
    Return the largest lucky integer in the array. If there is no lucky integer return -1.
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        System.out.println(findLucky(arr));
    }

    // BEATS 100%
    public static int findLucky(int[] arr) {
        int[] array = new int[501];
        for (int num : arr) {
            array[num]++;
        }
        for (int i = 500; i > 0; i--) {
            if (array[i] == i) return i;
        }
        return -1;
    }
}