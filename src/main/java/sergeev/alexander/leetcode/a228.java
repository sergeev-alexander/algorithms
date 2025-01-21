package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.List;

// 228. Summary Ranges
public class a228 {

    /*
    You are given a sorted unique integer array nums.

    A range [a,b] is the set of all integers from a to b (inclusive).
    Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
    That is, each element of nums is covered by exactly one of the ranges,
    and there is no integer x such that x is in one of the ranges but not in nums.
    Each range [a,b] in the list should be output as
    "a->b" if a != b
    "a" if a == b
     */

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9, 11};
        System.out.println(summaryRanges(nums));
    }

    // BEATS 100%
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int pos = 0;
        for ( ; pos < nums.length - 1; pos++) {
            boolean is = false;
            StringBuilder sb = new StringBuilder(String.valueOf(nums[pos]));
            while (pos < nums.length - 1 && nums[pos] + 1 == nums[pos + 1]) {
                is = true;
                pos++;
            }
            if (is) {
                sb.append("->").append(nums[pos]);
            }
            list.add(sb.toString());
        }
        if (pos == nums.length - 1) {
            list.add(String.valueOf(nums[pos]));
        }
        return list;
    }
}