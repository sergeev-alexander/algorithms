package sergeev.alexander.leetcode;

import java.util.ArrayList;
import java.util.List;

// 1431. Kids With the Greatest Number of Candies
public class a1431 {

    /*
    There are n kids with candies. You are given an integer array candies,
    where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies,
    denoting the number of extra candies that you have.
    Return a boolean array result of length n, where result[i] is true if,
    after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids,
    or false otherwise.
    Note that multiple kids can have the greatest number of candies.
     */

    public static void main(String[] args) {
        int[] arr = {2,3,5,1,3};
        int extra = 3;
        System.out.println(kidsWithCandies(arr, extra));
    }

    // BEATS 87%
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int num : candies) {
            max = Math.max(max, num);
        }
        List<Boolean> list = new ArrayList<>();
        for (int num : candies) {
            list.add(num + extraCandies >= max);
        }
        return list;
    }
}