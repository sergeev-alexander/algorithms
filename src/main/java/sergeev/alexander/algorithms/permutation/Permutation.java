package sergeev.alexander.algorithms.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permuteRecursive(arr));
    }

    // Recursive permutation
    public static List<List<Integer>> permuteRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteRecursive(nums, 0, result);
        return result;
    }

    // Recursive permutation
    public static void permuteRecursive(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();

            for (int num : nums) {
                list.add(num);
            }

            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permuteRecursive(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    // Iteractive permutation 1
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int[] arr = new int[n];
        result.add(toList(nums));

        int i = 0;
        while (i < n) {
            if (arr[i] < i) {
                if (i % 2 == 0) {
                    swap(nums, 0, i); // Чётное i
                } else {
                    swap(nums, arr[i], i); // Нечётное i
                }
                result.add(toList(nums)); // Сохраняем новую перестановку
                arr[i]++; // Увеличиваем счётчик
                i = 0; // Сбрасываем для следующей итерации
            } else {
                arr[i] = 0;
                i++;
            }
        }
        return result;
    }

    // Iteractive permutation 2
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int[] c = new int[n]; // Массив счётчиков (по умолчанию заполнен нулями)

        // Добавляем исходную перестановку
        result.add(toList(nums));

        int i = 0;
        while (i < n) {
            if (c[i] < i) {
                // Определяем, какие элементы менять местами
                if (i % 2 == 0) {
                    swap(nums, 0, i); // Для чётного i
                } else {
                    swap(nums, c[i], i); // Для нечётного i
                }
                // Добавляем новую перестановку в результат
                result.add(toList(nums));
                c[i]++; // Увеличиваем счётчик
                i = 0;  // Сбрасываем i для следующей итерации
            } else {
                c[i] = 0; // Обнуляем счётчик, если c[i] >= i
                i++;
            }
        }
        return result;
    }

    // Utility method
    private static List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    // Utility method
    public static void swap(int[] nums, int start, int i) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }
}
