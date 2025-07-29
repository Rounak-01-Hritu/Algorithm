//series print
import java.util.Scanner;

public class FibonacciSequence {
    public static void printFibonacci(int n) {
        long a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            long c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        printFibonacci(n);
        sc.close();
    }
}
