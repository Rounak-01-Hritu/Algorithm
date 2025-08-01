public class HeapifyExample {

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static void buildHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        int n = arr.length;

        System.out.print("Original array: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        buildHeap(arr, n);

        System.out.print("Max Heap: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}
