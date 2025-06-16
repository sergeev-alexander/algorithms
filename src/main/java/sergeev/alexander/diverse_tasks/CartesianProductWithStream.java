package sergeev.alexander.diverse_tasks;

import java.util.List;
import java.util.stream.Collectors;

public class CartesianProductWithStream {

    public static void main(String[] args) {

        List<String> list1 = List.of("a", "b", "c");
        List<String> list2 = List.of("1", "2", "3");

        List<String> result = generateCartesianProduct(list1, list2);

        result.forEach(System.out::println);

    }

    public static List<String> generateCartesianProduct(List<String> list1, List<String> list2) {
        return list1.stream()
                .flatMap(item1 -> list2.stream()
                        .map(item2 -> item1 + " " + item2))
                .collect(Collectors.toList());
    }
}
