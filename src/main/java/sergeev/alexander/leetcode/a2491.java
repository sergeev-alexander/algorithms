package sergeev.alexander.leetcode;

import java.util.Arrays;

// 2491. Divide Players Into Teams of Equal Skill
public class a2491 {

    /*
    You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player.
    Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.
    The chemistry of a team is equal to the product of the skills of the players on that team.
    Return the sum of the chemistry of all the teams,
    or return -1 if there is no way to divide the players into teams such that the total skill of each team is equal.
     */

    public static void main(String[] args) {
        int[] skill = {3,2,5,1,3,4};
        System.out.println(dividePlayers(skill));
    }

    // BEATS 77%
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int elementsSum = 0;
        for (int num : skill) {
            elementsSum += num;
        }
        int n = skill.length;
        if (elementsSum % (n / 2) != 0) return -1L;
        int target = elementsSum / (n / 2);
        long sum = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (skill[left] + skill[right] == target) {
                sum += (long) skill[left++] * skill[right--];
            } else return -1;
        }
        return sum;
    }

    // TLE
    public static long dividePlayers1(int[] skill) {
        int elementsSum = 0;
        for (int num : skill) {
            elementsSum += num;
        }
        int n = skill.length;
        if (elementsSum % (n / 2) != 0) return -1L;
        int target = elementsSum / (n / 2);
        long sum = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (skill[i] + skill[j] == target) {
                    sum += (long) skill[i] * skill[j];
                    count += 2;
                    skill[j] = 0;
                    skill[i] = 0;
                    break;
                }
            }
        }
        return sum == 0 || count != n ? -1 : sum;
    }
}