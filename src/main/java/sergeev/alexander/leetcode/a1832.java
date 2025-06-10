package sergeev.alexander.leetcode;

import java.util.BitSet;

// 1832. Check if the Sentence Is Pangram
public class a1832 {

    /*
    A pangram is a sentence where every letter of the English alphabet appears at least once.
    Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
     */

    public static void main(String[] args) {
        String s = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(s));
    }

    // BEATS 65%
    public static boolean checkIfPangram(String sentence) {
        boolean[] arr = new boolean[26];
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            int pos = sentence.charAt(i) - 'a';
            if (!arr[pos]) {
                arr[pos] = true;
                count++;
            }
        }
        return count == 26;
    }

    // BEATS 46%
    public static boolean checkIfPangram1(String sentence) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < sentence.length(); i++) {
            int pos = sentence.charAt(i) - 'a';
            bitSet.set(pos);
        }
        return bitSet.cardinality() == 26;
    }
}
