package sergeev.alexander.algorithms.huffman_algorithm;

public class Main {

    public static void main(String[] args) {
        String s = "abacabad";
        Huffman huffman = new Huffman(s);
        System.out.println(huffman.encode());
    }
}
