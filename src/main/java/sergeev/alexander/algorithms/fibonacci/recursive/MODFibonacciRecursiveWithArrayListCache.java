package sergeev.alexander.algorithms.fibonacci.recursive;

import java.util.ArrayList;
import java.util.List;

public class MODFibonacciRecursiveWithArrayListCache {

    private static final int MOD = (int) (1e9+7);
    private static final List<Integer> CACHE = new ArrayList<>();

    public static void main(String[] args) {
        int n = 122;
        System.out.println();
    }

    public static int modFibonacciRecursiveWithArrayListCache(int n) {
        if (n < 2) {
            return n;
        }
        for (int i = CACHE.size(); i <= n; i++) {
            int result = (modFibonacciRecursiveWithArrayListCache(i - 2)
                    + modFibonacciRecursiveWithArrayListCache(i - 1))
                    % MOD;
            CACHE.add(result);
        }
        return CACHE.get(n);
    }
}
