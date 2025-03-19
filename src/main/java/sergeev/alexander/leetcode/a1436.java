package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1436. Destination City
public class a1436 {

    /*
    You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi.
    Return the destination city, that is, the city without any path outgoing to another city.
    It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
     */

    public static void main(String[] args) {
        List<List<String>> list = List.of(
                List.of("B","C"),
                List.of("D","B"),
                List.of("C","A"));
        System.out.println(destCity(list));
    }

    // BEATS 100%
    public static String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }
        String current = paths.get(0).get(0);
        while (map.containsKey(current)) {
            current = map.get(current);
        }
        return current;
    }
}