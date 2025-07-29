import java.util.Scanner;

public class MagicSquare {
    static void generateMagicSquare(int n) {
        if (n % 2 == 0) {
            System.out.println("Magic square is only possible for odd n using this method.");
            return;
        }

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

        System.out.println("Magic Square of size " + n + ":");
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++)
                System.out.printf("%4d ", magic[x][y]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter odd size of magic square: ");
        int n = sc.nextInt();
        generateMagicSquare(n);
        sc.close();
    }
}
