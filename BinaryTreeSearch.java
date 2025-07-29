import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

class BST {
    Node root;

    Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data)
            root.left = insert(root.left, val);
        else if (val > root.data)
            root.right = insert(root.right, val);
        return root;
    }

    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (key < root.data)
            return search(root.left, key);
        return search(root.right, key);
    }
}

public class BinaryTreeSearch {
    public static void main(String[] args) {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);
        int choice, value, key;

        do {
            System.out.println("\n1. Insert\n2. Search\n3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    tree.root = tree.insert(tree.root, value);
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    key = sc.nextInt();
                    if (tree.search(tree.root, key))
                        System.out.println(key + " found in the tree.");
                    else
                        System.out.println(key + " not found in the tree.");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);

        sc.close();
    }
}
