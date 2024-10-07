package sergeev.alexander.algorithms.permutation.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationArrayWithIteration<T> {

    public List<T[]> list = new ArrayList<>();

    public void permuteIterative(int n, T[] elements) {
        int[] indexes = new int[n];
        int i = 0;
        list.add(elements);
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
                list.add(Arrays.copyOf(elements, elements.length));
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }
    }

    private void swap(T[] elements, int a, int b) {
        T tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }
}