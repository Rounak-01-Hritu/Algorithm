import java.util.Scanner;

public class MagicSquareSinglyEven {
    static int[][] generateOddMagicSquare(int n) {
        int[][] magic = new int[n][n];
        int i = 0, j = n / 2;
        for (int num = 1; num <= n * n; ) {
            if (i < 0 && j == n) {
                i += 2;
                j--;
            }
            if (i < 0) i = n - 1;
            if (j == n) j = 0;
            if (magic[i][j] != 0) {
                i += 2;
                j--;
                continue;
            } else {
                magic[i][j] = num++;
            }
            i--;
            j++;
        }
        return magic;
    }

    static void generateSinglyEvenMagicSquare(int n) {
        if (n % 2 != 0 || n % 4 == 0) {
            System.out.println("This method only works for singly even n (n % 4 == 2).");
            return;
        }

        int halfN = n / 2;
        int subSquareSize = halfN * halfN;
        int[][] subSquare = generateOddMagicSquare(halfN);
        int[][] magic = new int[n][n];

        // Fill 4 sub-squares
        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfN; j++) {
                int a = subSquare[i][j];
                magic[i][j] = a;
                magic[i + halfN][j + halfN] = a + subSquareSize;
                magic[i + halfN][j] = a + 2 * subSquareSize;
                magic[i][j + halfN] = a + 3 * subSquareSize;
            }
        }

        // Swap columns
        int k = (n - 2) / 4;
        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < k; j++) {
                int temp = magic[i][j];
                magic[i][j] = magic[i + halfN][j];
                magic[i + halfN][j] = temp;
            }
            for (int j = n - k + 1; j < n; j++) {
                int temp = magic[i][j];
                magic[i][j] = magic[i + halfN][j];
                magic[i + halfN][j] = temp;
            }
        }

        // Middle column swap
        for (int i = 0; i < halfN; i++) {
            int temp = magic[i][k];
            magic[i][k] = magic[i + halfN][k];
            magic[i + halfN][k] = temp;
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
        System.out.print("Enter singly even size of magic square (n % 4 == 2): ");
        int n = sc.nextInt();
        generateSinglyEvenMagicSquare(n);
        sc.close();
    }
}
