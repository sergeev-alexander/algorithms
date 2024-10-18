package sergeev.alexander.algorithms.fibonacci.iterative;

public class FibonacciIterative {
    
    private static final int MOD = (int) (1e9+7);

    public static void main(String[] args) {
        int n = 100_000;
        System.out.println(fibonacciIterative(n));
    }

    public static int fibonacciIterative(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return a;
    }
}