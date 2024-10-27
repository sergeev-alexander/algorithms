package sergeev.alexander.algorithms;

import java.util.LinkedList;
import java.util.List;

public class MaxDistinctTerms {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(findMaxDistinctTerms(n));
    }

    public static List<Integer> findMaxDistinctTerms(int n) {
        List<Integer> result = new LinkedList<>();
        int i = 1;
        while (n > 2 * i) {
            n -= i;
            result.add(i++);
        }
        result.add(n);
        return result;
    }
}
