import java.util.Scanner;

public class SelectionSort {

    static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Original array: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        selectionSort(arr, n);

        System.out.print("Sorted array: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        sc.close();
    }
}
