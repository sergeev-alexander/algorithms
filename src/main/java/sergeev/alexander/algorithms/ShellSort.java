package sergeev.alexander.algorithms;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int arr[] = {3, 4, 1, 2};

        shellSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int arr[]) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
    }
}
