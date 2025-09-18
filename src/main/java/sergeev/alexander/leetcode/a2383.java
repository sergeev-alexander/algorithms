package sergeev.alexander.leetcode;

// 2383. Minimum Hours of Training to Win a Competition
public class a2383 {

    /*
    You are entering a competition,
    and are given two positive integers initialEnergy and initialExperience denoting your initial energy and initial experience respectively.
    You are also given two 0-indexed integer arrays energy and experience, both of length n.
    You will face n opponents in order. The energy and experience of the ith opponent is denoted by energy[i] and experience[i] respectively.
    When you face an opponent, you need to have both strictly greater experience and energy to defeat them and move to the next opponent if available.
    Defeating the ith opponent increases your experience by experience[i], but decreases your energy by energy[i].
    Before starting the competition, you can train for some number of hours. After each hour of training,
    you can either choose to increase your initial experience by one, or increase your initial energy by one.
    Return the minimum number of training hours required to defeat all n opponents.
     */

    public static void main(String[] args) {
        int initialEnergy = 5, initialExperience = 3;
        int[] energy = {1,4,3,2}, experience = {2,6,3,1};
        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

    // BEATS 100%
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int requiredEnergy = 0;
        int energyDiff = 0;


        for (int num : energy) {
            requiredEnergy += num;
        }

        if (requiredEnergy >= initialEnergy) {
            energyDiff = Math.abs(requiredEnergy - initialEnergy) + 1;
        }

        int additionalExperience = 0;

        for (int num : experience) {
            if (initialExperience <= num) {
                int addition = Math.abs(num - initialExperience) + 1;
                additionalExperience += addition;
                initialExperience += addition;
            }
            initialExperience += num;
        }

        return energyDiff + additionalExperience;
    }
}