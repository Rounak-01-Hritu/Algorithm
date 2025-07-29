import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;
    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}

class CompareNode implements Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.freq - y.freq;
    }
}

public class HuffmanCoding {

    static void printCodes(Node root, String str) {
        if (root == null) return;

        if (root.ch != '$') // '$' denotes internal node
            System.out.println(root.ch + ": " + str);

        printCodes(root.left, str + "0");
        printCodes(root.right, str + "1");
    }

    static void HuffmanCodes(char[] chars, int[] freq, int n) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(n, new CompareNode());

        for (int i = 0; i < n; i++)
            minHeap.add(new Node(chars[i], freq[i]));

        while (minHeap.size() > 1) {
            Node left = minHeap.poll();
            Node right = minHeap.poll();

            Node newNode = new Node('$', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            minHeap.add(newNode);
        }

        printCodes(minHeap.peek(), "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.print("Enter characters: ");
        for (int i = 0; i < n; i++) chars[i] = sc.next().charAt(0);

        System.out.print("Enter frequencies: ");
        for (int i = 0; i < n; i++) freq[i] = sc.nextInt();

        System.out.println("Huffman Codes:");
        HuffmanCodes(chars, freq, n);

        sc.close();
    }
}
