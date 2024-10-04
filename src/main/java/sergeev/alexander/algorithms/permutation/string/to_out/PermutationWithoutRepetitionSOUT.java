package sergeev.alexander.algorithms.permutation.string.to_out;

public class PermutationWithoutRepetitionSOUT {

    public static void main(String[] args) {

        String str = "ABC";
        boolean[] visited = new boolean[str.length()];
        permute(str, visited, "")   ;

    }

    public static void permute(String str, boolean[] visited, String current) {
        if (str.length() == current.length()) {
            System.out.println(current);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permute(str, visited, current + str.charAt(i));
                visited[i] = false;
            }
        }
    }
}
