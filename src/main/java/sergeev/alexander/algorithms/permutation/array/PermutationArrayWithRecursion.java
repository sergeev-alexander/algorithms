package sergeev.alexander.algorithms.permutation.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationArrayWithRecursion<T> {

    public List<T[]> list = new ArrayList<>();

    public void permuteRecursive(int n, T[] elements) {
        if (n == 1) {
            T[] arr = Arrays.copyOf(elements, elements.length);
            list.add(arr);
        } else {
            for (int i = 0; i < n - 1; i++) {
                permuteRecursive(n - 1, elements);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            permuteRecursive(n - 1, elements);
        }
    }

    private void swap(T[] elements, int a, int b) {
        T tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }
}
