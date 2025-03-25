package sergeev.alexander.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

// 1496. Path Crossing
public class a1496 {

    /*
    Given a string path, where path[i] = 'N', 'S', 'E' or 'W',
    each representing moving one unit north, south, east, or west, respectively.
    You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
    Return true if the path crosses itself at any point, that is,
    if at any time you are on a location you have previously visited. Return false otherwise.
     */

    public static void main(String[] args) {
        String s = "NES";
        System.out.println(isPathCrossing(s));
    }

    // BEATS 99%
    public static boolean isPathCrossing(String path) {
        Map<Character, int[]> map = new HashMap<>();
        map.put('N', new int[]{1, 0});
        map.put('S', new int[]{-1, 0});
        map.put('E', new int[]{0, 1});
        map.put('W', new int[]{0, -1});

        class Coordinates {

            final int x;
            final int y;

            public Coordinates(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Coordinates that)) return false;
                return x == that.x && y == that.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

        Set<Coordinates> set = new HashSet<>();
        set.add(new Coordinates(0,0));

        Coordinates current = new Coordinates(0, 0);
        for (Character ch : path.toCharArray()) {
            int[] move = map.get(ch);
            Coordinates next = new Coordinates(current.x + move[0], current.y + move[1]);
            if (!set.add(next)) {
                return true;
            }
            current = next;
        }
        return false;
    }
}