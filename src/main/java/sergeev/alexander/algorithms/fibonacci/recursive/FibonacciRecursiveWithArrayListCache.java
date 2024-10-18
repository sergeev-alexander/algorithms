package sergeev.alexander.algorithms.fibonacci.recursive;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciRecursiveWithArrayListCache {

    private static final List<BigInteger> CACHE = new ArrayList<>();

    static {
        CACHE.add(BigInteger.ZERO);
        CACHE.add(BigInteger.ONE);
    }
    public static void main(String[] args) {
        int n = 122;
        System.out.println(fibonacciRecursiveWithArrayListCache(n));
    }

    public static BigInteger fibonacciRecursiveWithArrayListCache(int n) {
        if (n < 2) {
            return BigInteger.valueOf(n);
        }
        for (int i = CACHE.size(); i <= n; i++) {
            BigInteger result = fibonacciRecursiveWithArrayListCache(i-2)
                    .add(fibonacciRecursiveWithArrayListCache(i-1));
            CACHE.add(result);
        }
        return CACHE.get(n);
    }
}
