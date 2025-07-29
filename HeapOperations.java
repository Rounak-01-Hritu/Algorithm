import java.util.*;

class MaxHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    void heapifyDown(int i) {
        int n = heap.size();
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && heap.get(left) > heap.get(largest))
            largest = left;

        if (right < n && heap.get(right) > heap.get(largest))
            largest = right;

        if (largest != i) {
            Collections.swap(heap, i, largest);
            heapifyDown(largest);
        }
    }

    void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) > heap.get(parent)) {
                Collections.swap(heap, i, parent);
                i = parent;
            } else break;
        }
    }

    void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
        System.out.println(val + " inserted into heap.");
    }

    void deleteRoot() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty! Cannot delete.");
            return;
        }
        System.out.println("Deleted root: " + heap.get(0));
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) heapifyDown(0);
    }

    void display() {
        System.out.print("Heap elements: ");
        for (int x : heap) System.out.print(x + " ");
        System.out.println();
    }
}

public class HeapOperations {
    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        Scanner sc = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("\n1. Insert\n2. Delete Root\n3. Display\n4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    h.insert(value);
                    break;
                case 2:
                    h.deleteRoot();
                    break;
                case 3:
                    h.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}
