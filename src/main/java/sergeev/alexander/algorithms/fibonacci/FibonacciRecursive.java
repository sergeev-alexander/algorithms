package sergeev.alexander.algorithms.fibonacci;

public class FibonacciRecursive {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(fibonacciRecursive(n));
    }

    public static int fibonacciRecursive(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }
}
