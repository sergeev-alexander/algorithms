package sergeev.alexander.algorithms.huffman_algorithm;

import java.util.ArrayList;

class PriorityQueue {

    private final ArrayList<BinaryTree> list;
    private int size;

    public PriorityQueue() {
        list = new ArrayList<>();
        size = 0;
    }

    public void insert(BinaryTree newTree) {
        if (size == 0) {
            list.add(newTree);
        } else {
            for (int i = 0; i < size; i++) {
                if (list.get(i).getFrequency() > newTree.getFrequency()) {
                    list.add(i, newTree);
                    break;
                }
                if (i == size - 1) {
                    list.add(newTree);
                }
            }
        }
        size++;
    }

    public BinaryTree pop() {
        BinaryTree tmp = list.get(0);
        list.remove(0);
        size--;
        return tmp;
    }
}