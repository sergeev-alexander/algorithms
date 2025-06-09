package sergeev.alexander.leetcode;

// 1812. Determine Color of a Chessboard Square
public class a1812 {

    /*
    You are given coordinates, a string that represents the coordinates of a square of the chessboard.
    Return true if the square is white, and false if the square is black.
    The coordinate will always represent a valid chessboard square.
    The coordinate will always have the letter first, and the number second.
     */

    public static void main(String[] args) {
        String s = "a1";
        System.out.println(squareIsWhite(s));
        System.out.println(0 % 2);
    }

    // BEATS 100%
    public static boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) - '0') % 2 != 0 && (coordinates.charAt(1) - 'a') % 2 != 0
                || (coordinates.charAt(0) - '0') % 2 == 0 && (coordinates.charAt(1) - 'a') % 2 == 0;
    }
}