package sergeev.alexander.leetcode;

// 2380. Time Needed to Rearrange a Binary String
public class a2380 {

    /*
    You are given a binary string s. In one second, all occurrences of "01" are simultaneously replaced with "10".
    This process repeats until no occurrences of "01" exist.
    Return the number of seconds needed to complete this process.
     */

    public static void main(String[] args) {
        String s = "0110101";
        System.out.println(secondsToRemoveOccurrences(s));
    }

    // BEATS 95%
    public static int secondsToRemoveOccurrences(String s) {
        int zeroesCount = 0;
        int count = 0;
        for (char num : s.toCharArray()) {
            if (num == '0') zeroesCount++;
            else if (zeroesCount > 0) {
                count = Math.max(count + 1, zeroesCount);
            }
        }
        return count;
    }

    // BEATS 45%
    public static int secondsToRemoveOccurrences2(String s) {
        if (s.length() == 1) return 0;

        char[] arr = s.toCharArray();
        boolean was;
        int count = 0;

        do {
            was = false;

            for (int i = 0, j = 1; j < arr.length; ) {
                if (arr[i] == '0' && arr[j] == '1') {
                    arr[i] = '1';
                    arr[j] = '0';
                    i += 2;
                    j += 2;
                    was = true;
                } else {
                    i++;
                    j++;
                }
            }

            if (was) count++;

        } while (was);

        return count;
    }

    // BEATS 6%
    public static int secondsToRemoveOccurrences1(String s) {
        int count = 0;
        while (s.contains("01")) {
            s = s.replaceAll("01", "10");
            count++;
        }
        return count;
    }
}