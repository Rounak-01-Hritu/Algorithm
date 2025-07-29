//doubly

import java.util.Scanner;

public class MagicSquareEven {
    static void generateDoublyEvenMagicSquare(int n) {
        if (n % 4 != 0) {
            System.out.println("This method only works for doubly even (multiple of 4) n.");
            return;
        }

        int[][] magic = new int[n][n];
        int num = 1;
        int num2 = n * n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i % 4 == j % 4) || ((i % 4 + j % 4) == 3))
                    magic[i][j] = num2;
                else
                    magic[i][j] = num;
                num++;
                num2--;
            }
        }

        System.out.println("Magic Square of size " + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%4d ", magic[i][j]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter doubly even size of magic square (multiple of 4): ");
        int n = sc.nextInt();
        generateDoublyEvenMagicSquare(n);
        sc.close();
    }
}
