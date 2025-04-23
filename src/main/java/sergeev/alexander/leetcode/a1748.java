package sergeev.alexander.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// 1748. Sum of Unique Elements
public class a1748 {

    /*
    You are given an integer array nums.
    The unique elements of an array are the elements that appear exactly once in the array.
    Return the sum of all the unique elements of nums.
     */

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        System.out.println(sumOfUnique(nums));
    }

    // BEATS 100%
    public static int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num]++;
        }
        int sum = 0;
        for (int num : nums) {
            if (arr[num] == 1) {
                sum += num;
            }
        }
        return sum;
    }

    // FUN
    public static int sumOfUnique1(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), v -> 1, (o, n) -> o + 1, HashMap::new))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .sum();
    }
}
