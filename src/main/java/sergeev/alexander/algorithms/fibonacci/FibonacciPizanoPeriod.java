package sergeev.alexander.algorithms.fibonacci;
import java.util.*;

public class FibonacciPizanoPeriod {

    public static void main(String[] args) {
        long n = 1025L;
        long m = 55L;
        System.out.println(findRestOfDivision(n, m)); // 5
    }

    public static long findRestOfDivision(long n, long m) {
        List<Long> list = new ArrayList<>();
        list.add(0L);
        list.add(1L);
        for (int i = 2; i < 6L * m + 1L; i++) {
            list.add((list.get(i - 2) + list.get(i - 1)) % m);
            if (i > 2 && list.get(i) == 0L && list.get(i - 1) == 1) {
                return list.get((int) (n % i));
            }
        }
        return n % m;
    }
}
