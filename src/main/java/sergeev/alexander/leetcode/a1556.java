package sergeev.alexander.leetcode;

// 1556. Thousand Separator
public class a1556 {

    /*
    Given an integer n, add a dot (".") as the thousands separator and return it in string format.
     */

    public static void main(String[] args) {
        int n = 123;
        System.out.println(thousandSeparator(n));
    }

    // BEATS 100%
    public static String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int pos = sb.length() - 3;
        while (pos > 0) {
            sb.insert(pos, ".");
            pos -= 3;
        }
        return sb.toString();
    }
}