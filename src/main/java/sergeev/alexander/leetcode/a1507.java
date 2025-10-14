package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.Map;

// 1507. Reformat Date
public class a1507 {

    /*
    Given a date string in the form Day Month Year, where:
    Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
    Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
    Year is in the range [1900, 2100].
    Convert the date string to the format YYYY-MM-DD, where:
    YYYY denotes the 4 digit year.
    MM denotes the 2 digit month.
    DD denotes the 2 digit day.
     */

    public static void main(String[] args) {
        String s = "20th Oct 2052";
        System.out.println(reformatDate(s));
    }

    // BEATS 74%
    public static String reformatDate(String date) {
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        String[] arr = date.split(" ");

        return new StringBuilder(arr[2]).append("-").append(map.get(arr[1])).append("-").append(((arr[0].length() > 3) ?
                (arr[0].substring(0, 2)) :
                ("0" + arr[0].charAt(0)))).toString();
    }

    // BEATS 42%
    public static String reformatDate2(String date) {
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        String[] arr = date.split(" ");

        return arr[2] + "-" +
                map.get(arr[1]) + "-" +
                ((arr[0].length() > 3) ? (arr[0].substring(0,2)) : ("0" + arr[0].charAt(0)));
    }

    // BEATS 71%
    public static String reformatDate1(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] arr = date.split(" ");
        StringBuilder sb = new StringBuilder(arr[2]).append("-");

        for (int i = 0; i < months.length; i++) {
            if (arr[1].equals(months[i])) {
                sb.append(String.format("%02d", i + 1)).append("-");
                break;
            }
        }

        if (arr[0].length() > 3) {
            sb.append(arr[0], 0, 2);
        } else {
            sb.append("0").append(arr[0], 0, 1);
        }

        return sb.toString();
    }
}