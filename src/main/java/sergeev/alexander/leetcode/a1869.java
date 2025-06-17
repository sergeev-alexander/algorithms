package sergeev.alexander.leetcode;

// 1869. Longer Contiguous Segments of Ones than Zeros
public class a1869 {

    /*
    Given a binary string s, return true if the longest contiguous segment of 1's is strictly longer
    than the longest contiguous segment of 0's in s, or return false otherwise.
    For example, in s = "110100010" the longest continuous segment of 1s has length 2,
    and the longest continuous segment of 0s has length 3.
    Note that if there are no 0's, then the longest continuous segment of 0's is considered to have a length 0.
    The same applies if there is no 1's.
     */

    public static void main(String[] args) {
        String s = "0100011100";
        System.out.println(checkZeroOnes(s));
    }

    // BEATS 75%
    public static boolean checkZeroOnes(String s) {
        if (s.length() <= 2) {
            return s.equals("1") || s.equals("11");
        }

        int zeroCount = 0;
        int onesCount = 0;

        for (int i = 1; i < s.length(); i++) {
            int count = 0;

            while (i < s.length() && s.charAt(i - 1) == s.charAt(i)) {
                count++;
                i++;
            }

            if (s.charAt(i - 1) == '0') zeroCount = Math.max(zeroCount, count);
            else onesCount = Math.max(onesCount, count);
        }

        return onesCount > zeroCount;
    }
}