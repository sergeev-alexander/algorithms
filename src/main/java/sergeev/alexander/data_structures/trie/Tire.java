package sergeev.alexander.data_structures.trie;

import java.util.HashMap;
import java.util.Map;

public class Tire {

    private final TireNode root;

    public Tire() {
        root = new TireNode();
    }

    public void insert(String word) {
        TireNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.childrenMap.containsKey(ch)) {
                current.childrenMap.put(ch, new TireNode());
            }
            current = current.childrenMap.get(ch);
        }
        current.isLeaf = true;
    }

    public boolean search(String word) {
        TireNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.childrenMap.containsKey(ch)) return false;
            current = current.childrenMap.get(ch);
        }
        return current.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TireNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.childrenMap.containsKey(ch)) return false;
            current = current.childrenMap.get(ch);
        }
        return true;
    }

    static class TireNode {

        Map<Character, TireNode> childrenMap;
        boolean isLeaf;

        public TireNode() {
            this.childrenMap = new HashMap<>();
            this.isLeaf = false;
        }
    }
}
