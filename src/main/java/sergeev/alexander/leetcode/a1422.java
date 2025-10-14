package sergeev.alexander.leetcode;

// 1422. Maximum Score After Splitting a String
public class a1422 {

    /*
    Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings
    (i.e. left substring and right substring).
    The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
     */

    public static void main(String[] args) {
        String s = "00";
        System.out.println(maxScore(s));
    }

    // BEATS 99%
    public static int maxScore(String s) {
        int n = s.length();
        int[] zeroArr = new int[n];
        int[] onesArr = new int[n];
        int zeroCount = 0;
        int onesCount = 0;

        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (s.charAt(i) == '0') zeroCount++;
            if (s.charAt(j) == '1') onesCount++;
            zeroArr[i] = zeroCount;
            onesArr[j] = onesCount;
        }

        int max = 0;

        for (int i = 0, j = 1; j < n; i++, j++) {
            max = Math.max(max, zeroArr[i] + onesArr[j]);
        }

        return max;
    }
}