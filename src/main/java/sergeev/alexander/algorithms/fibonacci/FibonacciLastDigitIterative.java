package sergeev.alexander.algorithms.fibonacci;

public class FibonacciLastDigitIterative {

    public static void main(String[] args) {
        int n = 841645; // index of fibonacci number
        System.out.println(lastDigitOfFibonacciNumber(n)); // 5
    }

    public static int lastDigitOfFibonacciNumber(int index) {
        int[] arr = new int[index + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= index; i++) {
            arr[i] = (arr[i - 2] % 10) + (arr[i - 1] % 10);
        }
        return arr[index] % 10;
    }
}