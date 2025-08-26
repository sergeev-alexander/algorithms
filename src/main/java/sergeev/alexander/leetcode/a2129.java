package sergeev.alexander.leetcode;

// 2129. Capitalize the Title
public class a2129 {

    /*
    You are given a string title consisting of one or more words separated by a single space, where each word consists of English letters.
    Capitalize the string by changing the capitalization of each word such that:
    If the length of the word is 1 or 2 letters, change all letters to lowercase.
    Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
    Return the capitalized title.
     */

    public static void main(String[] args) {
        String s = "First leTTeR of EACH Word";
        System.out.println(capitalizeTitle(s));
    }

    // BEATS 94%
    public static String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();

        for (String s : title.split(" ")) {
            if (s.length() <= 2) {

                for (char ch : s.toCharArray()) {
                    if (ch < 'a') {
                        sb.append((char) (ch + 32));
                    } else {
                        sb.append(ch);
                    }
                }

                sb.append(" ");
            } else {
                if (s.charAt(0) > 'Z') {
                    sb.append((char) (s.charAt(0) - 32));
                } else {
                    sb.append(s.charAt(0));
                }

                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) < 'a') {
                        sb.append((char) (s.charAt(i) + 32));
                    } else {
                        sb.append(s.charAt(i));
                    }
                }

                sb.append(" ");
            }
        }

        return sb.substring(0, sb.length() - 1);
    }
}