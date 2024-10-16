package sergeev.alexander.algorithms.chebyshev_distance;

public class ChebyshevDistance {

    public static void main(String[] args) {
        int sx = 1, sy = 1, fx = 2, fy = 1, t = 2;
        System.out.println(isReachableAtTime(sx, sy, fx, fy, t));
    }

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t != 1;
        }
        // The Chebyshev distance
        return t >= Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
    }
}
