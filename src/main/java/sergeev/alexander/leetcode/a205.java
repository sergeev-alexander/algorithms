package sergeev.alexander.leetcode;

// 205. Isomorphic Strings
public class a205 {

    /*
    Given two strings s and t, determine if they are isomorphic.
    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.
     */

    public static void main(String[] args) {
        String s = "title";
        String t = "paper";
        System.out.println(isIsomorphic(s,t));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] arrS = new int[256];
        int[] arrT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (arrS[sChar] != arrT[tChar]) {
                return false;
            }
            arrS[sChar] = i + 1;
            arrT[tChar] = i + 1;
        }
        return true;
    }
}
