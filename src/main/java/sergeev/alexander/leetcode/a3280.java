package sergeev.alexander.leetcode;

// 3280. Convert Date to Binary
public class a3280 {

    /*
    You are given a string date representing a Gregorian calendar date in the yyyy-mm-dd format.
    date can be written in its binary representation obtained by converting year, month,
    and day to their binary representations without any leading zeroes and writing them down in year-month-day format.
    Return the binary representation of date.
     */

    public static void main(String[] args) {
        String date = "2080-02-29";
        System.out.println(convertDateToBinary(date));
    }

    // BEATS 100%
    public static String convertDateToBinary(String date) {
        return new StringBuilder()
                .append(Integer.toBinaryString(Integer.parseInt(date.substring(0, 4), 10)))
                .append("-")
                .append(Integer.toBinaryString(Integer.parseInt(date.substring(5, 7), 10)))
                .append("-")
                .append(Integer.toBinaryString(Integer.parseInt(date.substring(8), 10)))
                .toString();
    }

    // BEATS 42%
    public static String convertDateToBinary1(String date) {
        return Integer.toBinaryString(Integer.parseInt(date.substring(0, 4), 10)) +
                "-" + Integer.toBinaryString(Integer.parseInt(date.substring(5, 7), 10)) +
                "-" + Integer.toBinaryString(Integer.parseInt(date.substring(8), 10));
    }
}