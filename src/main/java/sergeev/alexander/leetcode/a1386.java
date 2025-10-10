package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.Map;

// 1386. Cinema Seat Allocation
public class a1386 {

    /*
    A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row, labelled from 1 to 10 as shown in the figure above.
    Given the array reservedSeats containing the numbers of seats already reserved, for example, reservedSeats[i] = [3,8]
    means the seat located in row 3 and labelled with 8 is already reserved.
    Return the maximum number of four-person groups you can assign on the cinema seats.
    A four-person group occupies four adjacent seats in one single row.
    Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent,
    but there is an exceptional case on which an aisle split a four-person group, in that case,
    the aisle split a four-person group in the middle, which means to have two people on each side.
     */

    public static void main(String[] args) {
        int n = 3;
        int[][] reservedSeats = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        System.out.println(maxNumberOfFamilies(n, reservedSeats));
    }

    // BEATS 100%
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, boolean[]> map = new HashMap<>();

        for (int[] arr : reservedSeats) {
            int row = arr[0] - 1;
            int seat = arr[1] - 1;
            if (seat == 0 || seat == 9) continue;

            map.computeIfAbsent(row, key -> new boolean[10])[seat] = true;
        }

        int count = 0;

        for (boolean[] arr : map.values()) {

            boolean firstFour = !arr[1] && !arr[2] && !arr[3] && !arr[4];
            boolean lastFour = !arr[5] && !arr[6] && !arr[7] && !arr[8];

            int rowCount = 0;

            if (firstFour) rowCount++;
            if (lastFour) rowCount++;
            if (rowCount == 0 && !arr[3] && !arr[4] && !arr[5] && !arr[6]) rowCount++;

            count += rowCount;
        }

        return (n - map.size()) * 2 + count;
    }

    // BEATS 95%
    public static int maxNumberOfFamilies2(int n, int[][] reservedSeats) {
        Map<Integer, boolean[]> map = new HashMap<>();

        for (int[] arr : reservedSeats) {
            int row = arr[0] - 1;
            map.computeIfAbsent(row, key -> new boolean[10])[arr[1] - 1] = true;
        }

        int count = 0;

        for (boolean[] arr : map.values()) {

            boolean one = !arr[1];
            boolean two = !arr[2];
            boolean three = !arr[3];
            boolean four = !arr[4];
            boolean five = !arr[5];
            boolean six = !arr[6];
            boolean seven = !arr[7];
            boolean eight = !arr[8];

            boolean firstFour = one && two && three && four;
            boolean lastFour = five && six && seven && eight;

            int rowCount = 0;

            if (firstFour) rowCount++;
            if (lastFour) rowCount++;
            if (rowCount == 0 && three && four && five && six) rowCount++;

            count += rowCount;
        }

        return (n - map.size()) * 2 + count;
    }

    // BEATS 92%
    public static int maxNumberOfFamilies1(int n, int[][] reservedSeats) {
        Map<Integer, boolean[]> map = new HashMap<>();

        for (int[] arr : reservedSeats) {
            int row = arr[0] - 1;
            map.computeIfAbsent(row, key -> new boolean[10])[arr[1] - 1] = true;
        }

        int count = 0;

        for (boolean[] arr : map.values()) {

            boolean one = !arr[1];
            boolean two = !arr[2];
            boolean three = !arr[3];
            boolean four = !arr[4];
            boolean five = !arr[5];
            boolean six = !arr[6];
            boolean seven = !arr[7];
            boolean eight = !arr[8];

            boolean firstFour = one && two && three && four;
            boolean middleFour = three && four && five && six;
            boolean lastFour = five && six && seven && eight;

            if (firstFour && lastFour) {
                count += 2;
            } else if (firstFour || middleFour || lastFour) {
                count++;
            }
        }

        return (n - map.size()) * 2 + count;
    }
}