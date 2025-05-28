package sergeev.alexander.leetcode;

// 1784. Check if Binary String Has at Most One Segment of Ones
public class a1784 {

    /*
    Given a binary string s without leading zeros, return true if s contains at most one contiguous segment of ones.
    Otherwise, return false.
     */

    public static void main(String[] args) {
        String s = "100011";
        System.out.println(checkOnesSegment(s));
    }

    // BEATS 100%
    public static boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    // BEATS 100%
    public static boolean checkOnesSegment1(String s) {
        boolean wasZero = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                wasZero = true;
                continue;
            }
            if (wasZero && s.charAt(i) == '1') {
                return false;
            }
        }
        return true;
    }
}