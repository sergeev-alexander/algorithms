package sergeev.alexander.algorithms.huffman_algorithm.implementation_1;

import java.util.*;


class Huffman {

    private final String text;
    private final Map<Character, Integer> frequensyMap;
    private final List<Node> nodeList;
    private final Node huffmanTree;
    private final Map<Character, String> codesMap;

    public Huffman(String text) {
        this.text = text;
        this.frequensyMap = countFrequency(text);
        this.nodeList = buildNodeList();
        this.huffmanTree = buildHuffmanTree(nodeList);
        this.codesMap = buildCodesMap();
    }

    public Huffman(String text, Map<Character, Integer> frequensyMap) {
        this.text = text;
        this.frequensyMap = frequensyMap;
        this.nodeList = buildNodeList();
        this.huffmanTree = buildHuffmanTree(nodeList);
        this.codesMap = buildCodesMap();
    }

    public String encode() {
        System.out.println(codesMap);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            stringBuilder.append(codesMap.get(text.charAt(i)));
        }
        return stringBuilder.toString();
    }

    public String decode(String encodedStr) {
        StringBuilder decoded = new StringBuilder();
        Node node = huffmanTree;
        for (int i = 0; i < encodedStr.length(); i++) {
            node = encodedStr.charAt(i) == '0' ? node.getLeft() : node.getRight();
            if (node.getContent() != null) {
                decoded.append(node.getContent());
                node = huffmanTree;
            }
        }
        return decoded.toString();
    }

    private Map<Character, Integer> countFrequency(String text) {
        Map<Character, Integer> frequancyMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            frequancyMap.merge(text.charAt(i), 1, Integer::sum);
        }
        return frequancyMap;
    }

    private List<Node> buildNodeList() {
        ArrayList<Node> nodeList = new ArrayList<>();
        for (Character ch : frequensyMap.keySet()) {
            nodeList.add(new Node(ch, frequensyMap.get(ch)));
        }
        return nodeList;
    }

    private Node buildHuffmanTree(List<Node> nodeList) {
        while (nodeList.size() > 1) {
            Collections.sort(nodeList);
            Node left = nodeList.remove(nodeList.size() - 1);
            Node right = nodeList.remove(nodeList.size() - 1);
            Node parent = new Node(null, right.getWeight() + left.getWeight(), left, right);
            nodeList.add(parent);
        }
        return nodeList.get(0);
    }

    private Map<Character, String> buildCodesMap() {
        Map<Character, String> codesMap = new HashMap<>();
        for (Character c : frequensyMap.keySet()) {
            codesMap.put(c, huffmanTree.getCodeForCharacter(c, ""));
        }
        return codesMap;
    }
}