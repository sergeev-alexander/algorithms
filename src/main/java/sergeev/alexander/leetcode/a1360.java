package sergeev.alexander.leetcode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// 1360. Number of Days Between Two Dates
public class a1360 {

    /*
    Write a program to count the number of days between two dates.
    The two dates are given as strings, their format is YYYY-MM-DD.
     */

    public static void main(String[] args) {
        String d1 = "1971-06-29";
        String d2 = "2010-09-23";
        System.out.println(daysBetweenDates(d1, d2));
    }

    // BEATS 58%
    public static int daysBetweenDates(String date1, String date2) {
        String[] arr1 = date1.split("-");
        String[] arr2 = date2.split("-");
        LocalDate d1 = LocalDate.of(Integer.parseInt(arr1[0]), Integer.parseInt(arr1[1]), Integer.parseInt(arr1[2]));
        LocalDate d2 = LocalDate.of(Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1]), Integer.parseInt(arr2[2]));
        int result = (int) d1.toEpochDay() - (int) d2.toEpochDay();
        return result >= 0 ? result : result * -1;
    }

    // BEATS 58%
    public static int daysBetweenDates2(String date1, String date2) {
        String[] arr1 = date1.split("-");
        String[] arr2 = date2.split("-");
        LocalDate d1 = LocalDate.of(Integer.parseInt(arr1[0]), Integer.parseInt(arr1[1]), Integer.parseInt(arr1[2]));
        LocalDate d2 = LocalDate.of(Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1]), Integer.parseInt(arr2[2]));
        int result = (int) ChronoUnit.DAYS.between(d1, d2);
        return result >= 0 ? result : result * -1;
    }

    // BEATS 17%
    public static int daysBetweenDates1(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d1 = LocalDate.from(formatter.parse(date1));
        LocalDate d2 = LocalDate.from(formatter.parse(date2));
        int result = (int) ChronoUnit.DAYS.between(d1, d2);
        return result >= 0 ? result : result * -1;
    }
}