package sergeev.alexander.data_structures.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.childrenMap.containsKey(ch)) {
                current.childrenMap.put(ch, new TrieNode());
            }
            current = current.childrenMap.get(ch);
        }
        current.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.childrenMap.containsKey(ch)) return false;
            current = current.childrenMap.get(ch);
        }
        return current.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.childrenMap.containsKey(ch)) return false;
            current = current.childrenMap.get(ch);
        }
        return true;
    }

    static class TrieNode {

        Map<Character, TrieNode> childrenMap;
        boolean isLeaf;

        public TrieNode() {
            this.childrenMap = new HashMap<>();
            this.isLeaf = false;
        }
    }
}
