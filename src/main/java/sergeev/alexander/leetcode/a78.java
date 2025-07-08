package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.List;

// 78. Subsets
public class a78 {

    /*
    Given an integer array nums of unique elements, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        subsets(arr).forEach(System.out::println);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, nums, new ArrayList<>(), 0);
        return list;
    }

    public static void backTrack(List<List<Integer>> resultList, int[] nums, List<Integer> currentList, int position) {
        resultList.add(new ArrayList<>(currentList));

        for (int i = position; i < nums.length; i++) {
            currentList.add(nums[i]);
            backTrack(resultList, nums, currentList, ++position);
            currentList.remove(currentList.size() - 1);
        }
    }
}