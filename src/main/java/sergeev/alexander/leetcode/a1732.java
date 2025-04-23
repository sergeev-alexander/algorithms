package sergeev.alexander.leetcode;

// 1732. Find the Highest Altitude
public class a1732 {

    /*
    There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
    The biker starts his trip on point 0 with altitude equal 0.
    You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i and i + 1
    for all (0 <= i < n). Return the highest altitude of a point.
     */

    public static void main(String[] args) {
        int[] arr = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(arr));
    }

    // BEATS 100%
    public static int largestAltitude(int[] gain) {
        int max = 0;
        int current = 0;
        for (int num : gain) {
            current += num;
            max = Math.max(max, current);
        }
        return max;
    }
}