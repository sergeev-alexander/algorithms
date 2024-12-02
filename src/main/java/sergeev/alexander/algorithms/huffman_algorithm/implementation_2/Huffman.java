package sergeev.alexander.algorithms.huffman_algorithm.implementation_2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

    static Map<Character, Node> codesMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        String encodedString = new Huffman().run(input);
        System.out.println(codesMap);
        System.out.println(encodedString);
    }

    private String run(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            frequencyMap.merge(ch, 1, Integer::sum);
        }
        codesMap = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            priorityQueue.add(node);
            codesMap.put(entry.getKey(), node);
        }
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            priorityQueue.add(new InternalNode(first, second));
        }
        Node root = priorityQueue.poll();
        if (frequencyMap.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode("");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            stringBuilder.append(codesMap.get(ch).code);
        }
        return stringBuilder.toString();
    }

    class Node implements Comparable<Node> {

        final int frequency;
        String code;

        public Node(int frequency) {
            this.frequency = frequency;
        }

        public void buildCode(String code) {
            this.code = code;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.frequency, other.frequency);
        }

        @Override
        public String toString() {
            return code;
        }
    }

    class InternalNode extends Node {

        Node left;
        Node right;

        public InternalNode(Node left, Node right) {
            super(left.frequency + right.frequency);
            this.left = left;
            this.right = right;
        }

        @Override
        public void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    class LeafNode extends Node {

        char symbol;

        public LeafNode(char ch, int frequency) {
            super(frequency);
            symbol = ch;
        }
    }
}
