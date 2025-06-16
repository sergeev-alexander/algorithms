package sergeev.alexander.diverse_tasks;

public class Recursion {

    public static void main(String[] args) {

        int num = 5;

        int[] arr = {2, 4, 6, 9, 7};

        countDown(num);

        System.out.println(factorial(num));

        System.out.println(recursionSum(0, arr));

    }

    public static void countDown(int num) {
        if (num < 0) return;
        else {
            System.out.println(num);
            countDown(num - 1);
        }
    }

    public static int factorial(int num) {
        if (num == 1) return num;
        else return num * factorial(num - 1);
    }

    public static int recursionSum(int index, int[] arr) {
        if (index == arr.length - 1) return arr[index];
        else return arr[index] + recursionSum(index + 1, arr);
    }

}
