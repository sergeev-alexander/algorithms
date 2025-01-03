package sergeev.alexander;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class Temp {

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