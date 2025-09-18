package sergeev.alexander.leetcode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// 2409. Count Days Spent Together
public class a2409 {

    /*
    Alice and Bob are traveling to Rome for separate business meetings.
    You are given 4 strings arriveAlice, leaveAlice, arriveBob, and leaveBob.
    Alice will be in the city from the dates arriveAlice to leaveAlice (inclusive),
    while Bob will be in the city from the dates arriveBob to leaveBob (inclusive).
    Each will be a 5-character string in the format "MM-DD", corresponding to the month and day of the date.
    Return the total number of days that Alice and Bob are in Rome together.
    You can assume that all dates occur in the same calendar year, which is not a leap year.
    Note that the number of days per month can be represented as: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31].
     */

    public static void main(String[] args) {
        String aA = "08-15", lA = "08-18", aB = "08-16", lB = "08-19";
        System.out.println(countDaysTogether(aA, lA, aB, lB));
    }

    // BEATS 3%
    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String year = "2025-";

        LocalDate startA = LocalDate.from(formatter.parse(year + arriveAlice));
        LocalDate endA = LocalDate.from(formatter.parse(year + leaveAlice));
        LocalDate startB = LocalDate.from(formatter.parse(year + arriveBob));
        LocalDate endB = LocalDate.from(formatter.parse(year + leaveBob));

        if (!endA.isBefore(startB) && !endB.isBefore(startA)) {
            LocalDate maxStart = startA.isAfter(startB) ? startA : startB;
            LocalDate minEnd = endA.isBefore(endB) ? endA : endB;
            return (int) ChronoUnit.DAYS.between(maxStart, minEnd) + 1;
        }

        return 0;
    }

    // BEATS 6%
    public static int countDaysTogether1(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        LocalDate startA = LocalDate.of(2025, Integer.parseInt(arriveAlice.split("-")[0]), (Integer.parseInt(arriveAlice.split("-")[1])));
        LocalDate endA = LocalDate.of(2025, Integer.parseInt(leaveAlice.split("-")[0]), (Integer.parseInt(leaveAlice.split("-")[1])));
        LocalDate startB = LocalDate.of(2025, Integer.parseInt(arriveBob.split("-")[0]), (Integer.parseInt(arriveBob.split("-")[1])));
        LocalDate endB = LocalDate.of(2025, Integer.parseInt(leaveBob.split("-")[0]), (Integer.parseInt(leaveBob.split("-")[1])));

        if (!endA.isBefore(startB) && !endB.isBefore(startA)) {
            LocalDate maxStart = startA.isAfter(startB) ? startA : startB;
            LocalDate minEnd = endA.isBefore(endB) ? endA : endB;
            return (int) ChronoUnit.DAYS.between(maxStart, minEnd) + 1;
        }

        return 0;
    }
}
