package sergeev.alexander.leetcode;

// 3516. Find Closest Person
public class a3516 {

    /*
    You are given three integers x, y, and z, representing the positions of three people on a number line:
    x is the position of Person 1.
    y is the position of Person 2.
    z is the position of Person 3, who does not move.
    Both Person 1 and Person 2 move toward Person 3 at the same speed.
    Determine which person reaches Person 3 first:
    Return 1 if Person 1 arrives first.
    Return 2 if Person 2 arrives first.
    Return 0 if both arrive at the same time.
    Return the result accordingly.
     */

    public static void main(String[] args) {
        int x = 1, y = 5, z = 3;
        System.out.println(findClosest(x,y,z));
    }

    // BEATS 100%
    public static int findClosest(int x, int y, int z) {
        int xDif = Math.abs(z-x);
        int yDif = Math.abs(z-y);

        return xDif < yDif ? 1 : yDif < xDif ? 2 : 0;
    }
}
