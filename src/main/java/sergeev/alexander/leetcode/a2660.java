package sergeev.alexander.leetcode;

// 2660. Determine the Winner of a Bowling Game
public class a2660 {

    /*
    You are given two 0-indexed integer arrays player1 and player2,
    representing the number of pins that player 1 and player 2 hit in a bowling game, respectively.
    The bowling game consists of n turns, and the number of pins in each turn is exactly 10.
    Assume a player hits xi pins in the ith turn. The value of the ith turn for the player is:
    2xi if the player hits 10 pins in either (i - 1)th or (i - 2)th turn.
    Otherwise, it is xi.
    The score of the player is the sum of the values of their n turns.
    Return
    1 if the score of player 1 is more than the score of player 2,
    2 if the score of player 2 is more than the score of player 1, and
    0 in case of a draw.
     */

    public static void main(String[] args) {
        int[] one = {1, 1, 1, 10, 10, 10, 10};
        int[] two = {10, 10, 10, 10, 1, 1, 1};
        System.out.println(isWinner(one, two));
    }

    // BEATS 100%
    public static int isWinner(int[] player1, int[] player2) {
        int firstSum = 0;
        int secondSum = 0;
        int firstBonus = 0;
        int secondBonus = 0;
        for (int i = 0; i < player1.length; i++) {
            int firstMultiplication = firstBonus > 0 ? 2 : 1;
            if (player1[i] == 10) {
                firstSum += player1[i] * firstMultiplication;
                firstBonus = 2;
            } else {
                firstSum += player1[i] * firstMultiplication;
                firstBonus--;
            }
            int secondMultiplication = secondBonus > 0 ? 2 : 1;
            if (player2[i] == 10) {
                secondSum += player2[i] * secondMultiplication;
                secondBonus = 2;
            } else {
                secondSum += player2[i] * secondMultiplication;
                secondBonus--;
            }
        }
        return firstSum == secondSum ? 0 : firstSum > secondSum ? 1 : 2;
    }
}