package sergeev.alexander.leetcode;

// 1678. Goal Parser Interpretation
public class a1678 {

    /*
    You own a Goal Parser that can interpret a string command.
    The command consists of an alphabet of "G", "()" and/or "(al)" in some order.
    The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al".
    The interpreted strings are then concatenated in the original order.
    Given the string command, return the Goal Parser's interpretation of command.
     */

    public static void main(String[] args) {
        String command = "G()()()()(al)";
        System.out.println(interpret(command));
    }

    // BEATS 100%
    public static String interpret(String command) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                stringBuilder.append('G');
            } else {
                if (command.charAt(i + 1) == ')') {
                    stringBuilder.append('o');
                    i++;
                } else {
                    stringBuilder.append("al");
                    i += 3;
                }
            }
        }

        return stringBuilder.toString();
    }
}
