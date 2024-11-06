package sergeev.alexander.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Temp {

    public static void main(String[] args) {
        String s = """
                4 14
                a: 0
                b: 10
                c: 110
                d: 111
                01001100100111
                """;
        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();
        int length = scanner.nextInt();
        scanner.nextLine();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < mapSize; i++) {
            String[] arr = scanner.nextLine().split(": ");
            map.put(arr[1], arr[0]);
        }
        String str = scanner.nextLine();
        System.out.println(decode(map, str, length));
    }

    public static String decode(Map<String, String> map, String str, int length) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < length) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (str.substring(count).startsWith(entry.getKey())) {
                    sb.append(entry.getValue());
                    count += entry.getKey().length();
                }
            }
        }
        return sb.toString();
    }
}
