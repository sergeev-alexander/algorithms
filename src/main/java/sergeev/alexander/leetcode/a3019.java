package sergeev.alexander.leetcode;

// 3019. Number of Changing Keys
public class a3019 {

    /*
    You are given a 0-indexed string s typed by a user. Changing a key is defined as using a key different from the last used key.
    For example, s = "ab" has a change of a key while s = "bBBb" does not have any.
    Return the number of times the user had to change the key.
    Note: Modifiers like shift or caps lock won't be counted in changing the key that is
    if a user typed the letter 'a' and then the letter 'A' then it will not be considered as a changing of key.
     */

    public static void main(String[] args) {
        String s = "aAbBcC";
        System.out.println(countKeyChanges(s));
    }

    // BEATS 100%
    public static int countKeyChanges(String s) {
        s = s.toLowerCase();
        int count = 0;
        char current = s.charAt(0);

        for (char ch : s.toCharArray()) {
            if (ch != current) {
                count++;
                current = ch;
            }
        }

        return count;
    }
}