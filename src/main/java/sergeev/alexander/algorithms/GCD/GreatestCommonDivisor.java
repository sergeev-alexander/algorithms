package sergeev.alexander.algorithms.GCD;

public class GreatestCommonDivisor {

    public static void main(String[] args) {

        int a = 14 * 5;
        int b = 14 * 10;
        System.out.println(recursiveGCD(a, b));
        System.out.println(iterativeGCD(a, b));
    }

    public static int recursiveGCD(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a >= b) return recursiveGCD(a % b, b);
        else return recursiveGCD(b % a, a);
    }

    public static int iterativeGCD(int a, int b) {
        while (true) {
            if (a == 0) return b;
            if (b == 0) return a;
            if (a >= b) {
                a %= b;
            } else {
                b %= a;
            }
        }
    }

    public static int iterativeGCD_SLOW(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int result = 1;
        for (int i = 2; i <= Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return result;
    }
}
