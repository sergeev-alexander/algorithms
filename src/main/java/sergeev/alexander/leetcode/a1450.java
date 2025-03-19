package sergeev.alexander.leetcode;

// 1450. Number of Students Doing Homework at a Given Time
public class a1450 {

    /*
    Given two integer arrays startTime and endTime and given an integer queryTime.
    The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
    Return the number of students doing their homework at time queryTime. More formally,
    return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.
     */

    public static void main(String[] args) {
        int[] start = {1,2,3};
        int[] end = {3,2,7};
        int q = 4;
        System.out.println(busyStudent(start,end,q));
    }

    // BEATS 100%
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) count++;
        }
        return count;
    }
}