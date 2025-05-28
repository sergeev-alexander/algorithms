package sergeev.alexander.leetcode;

// 1791. Find Center of Star Graph
public class a1791 {

    /*
    There is an undirected star graph consisting of n nodes labeled from 1 to n.
    A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
    You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi.
    Return the center of the given star graph.
     */

    public static void main(String[] args) {
        int[][] arr = {{1,2},{5,1},{1,3},{1,4}};
        System.out.println(findCenter(arr));
    }

    // BEATS 100%
    public static int findCenter(int[][] edges) {
        int[] arr = new int[edges.length + 2];
        for (int[] edge : edges) {
            for (int i : edge) {
                arr[i]++;
                if (arr[i] > 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    // BEATS 36%
    public static int findCenter1(int[][] edges) {
        int[] arr = new int[edges.length + 2];
        for (int[] edge : edges) {
            for (int i : edge) {
                arr[i]++;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 1) return i;
        }
        return -1;
    }
}