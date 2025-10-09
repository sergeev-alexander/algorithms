package sergeev.alexander.leetcode;

// 1385. Find the Distance Value Between Two Arrays
public class a1385 {

    /*
    Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
    The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
     */

    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr1 = {4,5,8}, arr2 = {10,9,1,8};
        int d = 2;
        System.out.println(findTheDistanceValue(arr1, arr2, d));
    }

    // BEATS 97%
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = arr1.length;

        for (int i : arr1) {

            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}