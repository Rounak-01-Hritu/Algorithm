#include <bits/stdc++.h>
using namespace std;

class MaxHeap {
    vector<int> heap;

    void heapifyDown(int i) {
        int n = heap.size();
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && heap[left] > heap[largest])
            largest = left;

        if (right < n && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            swap(heap[i], heap[largest]);
            heapifyDown(largest);
        }
    }

    void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[i] > heap[parent]) {
                swap(heap[i], heap[parent]);
                i = parent;
            } else break;
        }
    }

public:
    void insert(int val) {
        heap.push_back(val);
        heapifyUp(heap.size() - 1);
        cout << val << " inserted into heap.\n";
    }

    void deleteRoot() {
        if (heap.empty()) {
            cout << "Heap is empty! Cannot delete.\n";
            return;
        }
        cout << "Deleted root: " << heap[0] << endl;
        heap[0] = heap.back();
        heap.pop_back();
        heapifyDown(0);
    }

    void display() {
        cout << "Heap elements: ";
        for (int x : heap) cout << x << " ";
        cout << endl;
    }
};

int main() {
    MaxHeap h;
    int choice, value;
    do {
        cout << "\n1. Insert\n2. Delete Root\n3. Display\n4. Exit\nEnter choice: ";
        cin >> choice;
        switch (choice) {
        case 1:
            cout << "Enter value to insert: ";
            cin >> value;
            h.insert(value);
            break;
        case 2:
            h.deleteRoot();
            break;
        case 3:
            h.display();
            break;
        case 4:
            cout << "Exiting...\n";
            break;
        default:
            cout << "Invalid choice!\n";
        }
    } while (choice != 4);
    return 0;
}
