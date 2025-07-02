package sergeev.alexander.leetcode;

// 1893. Check if All the Integers in a Range Are Covered
public class a1893 {

    /*
    You are given a 2D integer array ranges and two integers left and right.
    Each ranges[i] = [starti, endi] represents an inclusive interval between starti and endi.
    Return true if each integer in the inclusive range [left, right] is covered by at least one interval in ranges. Return false otherwise.
    An integer x is covered by an interval ranges[i] = [starti, endi] if starti <= x <= endi.
     */

    public static void main(String[] args) {
        int[][] arr = {{1,10}, {10,20}};
        int left = 21, right = 21;
        System.out.println(isCovered(arr, left, right));
    }

    // BEATS 100%
    public static boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean isCovered = false;

            for (int[] arr : ranges) {
                if (arr[0] <= i && arr[1] >= i) {
                    isCovered = true;
                    break;
                }
            }

            if (!isCovered) return false;
        }

        return true;
    }

    // BEATS 44%
    public static boolean isCovered1(int[][] ranges, int left, int right) {
        int[] array = new int[51];
        for (int[] arr : ranges) {
            for (int i = arr[0]; i <= arr[1]; i++) {
                array[i]++;
            }
        }
        for (int i = left; i <= right; i++) {
            if (array[i] == 0) return false;
        }
        return true;
    }
}