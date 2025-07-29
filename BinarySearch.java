import java.util.Scanner;

public class BinarySearch {

    // Iterative Binary Search
    static int binarySearchIterative(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Recursive Binary Search
    static int binarySearchRecursive(int[] arr, int low, int high, int key) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                return binarySearchRecursive(arr, mid + 1, high, key);
            else
                return binarySearchRecursive(arr, low, mid - 1, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter elements in sorted order: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int result = binarySearchIterative(arr, key);
        if (result != -1)
            System.out.println("Element found at index " + result + " (iterative)");
        else
            System.out.println("Element not found (iterative)");

        result = binarySearchRecursive(arr, 0, n - 1, key);
        if (result != -1)
            System.out.println("Element found at index " + result + " (recursive)");
        else
            System.out.println("Element not found (recursive)");

        sc.close();
    }
}
