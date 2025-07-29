//iterative
//efficient
import java.util.Scanner;

public class FibonacciIterative {
    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        long a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
        sc.close();
    }
}
