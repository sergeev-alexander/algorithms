package sergeev.alexander.leetcode;

import java.util.Arrays;

// 2126. Destroying Asteroids
public class a2126 {

    /*
    You are given an integer mass, which represents the original mass of a planet.
    You are further given an integer array asteroids, where asteroids[i] is the mass of the ith asteroid.
    You can arrange for the planet to collide with the asteroids in any arbitrary order.
    If the mass of the planet is greater than or equal to the mass of the asteroid,
    the asteroid is destroyed and the planet gains the mass of the asteroid.
    Otherwise, the planet is destroyed.
    Return true if all asteroids can be destroyed. Otherwise, return false.
     */

    public static void main(String[] args) {
        int[] arr = {3, 9, 19, 5, 21};
        int m = 10;
        System.out.println(asteroidsDestroyed(m, arr));
    }


    // BEATS 69%
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long mas = mass;

        for (int num : asteroids) {
            if (mas >= num) {
                mas += num;
            } else {
                return false;
            }
        }

        return true;
    }
}