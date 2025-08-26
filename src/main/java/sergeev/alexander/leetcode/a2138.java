package sergeev.alexander.leetcode;

import java.util.Arrays;

// 2138. Divide a String Into Groups of Size k
public class a2138 {

    /*
    A string s can be partitioned into groups of size k using the following procedure:
    The first group consists of the first k characters of the string, the second group consists of the next k characters of the string, and so on.
    Each element can be a part of exactly one group.
    For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
    Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating all the groups in order,
    the resultant string should be s.
    Given the string s, the size of each group k and the character fill, return a string array denoting the composition of every group s has been divided into,
    using the above procedure.
     */

    public static void main(String[] args) {
        String s = "abcdefghij";
        int k = 3;
        char ch = 'x';
        System.out.println(Arrays.toString(divideString(s, k, ch)));
    }

    // BEATS 95%
    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] resultArr = new String[n % k == 0 ? n / k : n / k + 1];
        int pos = 0;

        for (int i = 0; i < resultArr.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < k; j++) {
                if (pos < s.length()) {
                    sb.append(s.charAt(pos++));
                } else {
                    sb.append(fill);
                }
            }
            resultArr[i] = sb.toString();
        }

        return resultArr;
    }
}