package sergeev.alexander.leetcode;

// 1624. Largest Substring Between Two Equal Characters
public class a1624 {

    /*
    Given a string s, return the length of the longest substring between two equal characters, excluding the two characters.
    If there is no such substring return -1.
    A substring is a contiguous sequence of characters within a string.
     */

    public static void main(String[] args) {
        String s = "mgntdygtxrvxjnwksqhxuxtrv";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    // BETAS 100%
    public static int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        boolean[] seen = new boolean[26];
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (seen[pos]) {
                max = Math.max(max, i - arr[pos] - 1);
            } else {
                seen[pos] = true;
                arr[pos] = i;
            }
        }
        return max;
    }
}