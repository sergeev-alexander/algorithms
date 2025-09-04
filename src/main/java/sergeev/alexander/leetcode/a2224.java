package sergeev.alexander.leetcode;

// 2224. Minimum Number of Operations to Convert Time
public class a2224 {

    /*
    You are given two strings current and correct representing two 24-hour times.
    24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59.
    The earliest 24-hour time is 00:00, and the latest is 23:59.
    In one operation you can increase the time current by 1, 5, 15, or 60 minutes. You can perform this operation any number of times.
    Return the minimum number of operations needed to convert current to correct.
     */

    public static void main(String[] args) {
        String s1 = "09:41", s2 = "10:34";
        System.out.println(convertTime(s1, s2));
    }

    // BEATS 100%
    public static int convertTime(String current, String correct) {
        int currentMinutes = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3));
        int targetMinutes = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3));
        int difference = targetMinutes - currentMinutes;

        int count = 0;

        count += difference / 60;
        difference %= 60;
        count += difference / 15;
        difference %= 15;
        count += difference / 5;
        difference %= 5;
        count += difference;

        return count;
    }

    // BETATS 89%
    public static int convertTime1(String current, String correct) {
        int currentMinutes = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3));
        int targetMinutes = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3));

        int count = 0;

        while (currentMinutes < targetMinutes) {
            if ((currentMinutes + 60) <= targetMinutes) {
                currentMinutes += 60;
            } else if ((currentMinutes + 15) <= targetMinutes) {
                currentMinutes += 15;
            } else if ((currentMinutes + 5) <= targetMinutes) {
                currentMinutes += 5;
            } else {
                currentMinutes++;
            }

            count++;
        }

        return count;
    }
}