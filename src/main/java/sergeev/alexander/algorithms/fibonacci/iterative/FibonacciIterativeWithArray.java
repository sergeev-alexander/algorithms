package sergeev.alexander.algorithms.fibonacci.iterative;

public class FibonacciIterativeWithArray {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(fibonacciIterative(n));
    }

    public static long fibonacciIterative(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0L;
        arr[1] = 1L;
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
