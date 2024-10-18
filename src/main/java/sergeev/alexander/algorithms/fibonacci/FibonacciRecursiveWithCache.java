package sergeev.alexander.algorithms.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciRecursiveWithCache {

    private static final Map<Integer, BigInteger> CACHE = new HashMap<>();

    public static void main(String[] args) {
        int n = 112;
        System.out.println(fibonacciRecursiveWithCache(n));
    }

    public static BigInteger fibonacciRecursiveWithCache(int n) {
        if (n < 2) {
            return BigInteger.valueOf(n);
        }
        if (!CACHE.containsKey(n)) {
            for (int i = 2; i <= n; i++) {
                BigInteger result = fibonacciRecursiveWithCache(i - 2).add(fibonacciRecursiveWithCache(i - 1));
                CACHE.put(n, result);

            }
        }
        return CACHE.get(n);
    }
}