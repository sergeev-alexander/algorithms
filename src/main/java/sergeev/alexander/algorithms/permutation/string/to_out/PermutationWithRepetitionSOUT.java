package sergeev.alexander.algorithms.permutation.string.to_out;

public class PermutationWithRepetitionSOUT {

    public static void main(String[] args) {

        String str = "ABC";
        int n = 4;

        permute(str, n, "");

    }

    public static void permute(String str, int n, String curr) {
        if (curr.length() == n) {
            System.out.println(curr);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            permute(str, n, curr + str.charAt(i));
        }
    }
}

