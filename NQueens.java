// Java - N Queens Problem (Backtracking)
import java.util.*;

public class NQueens {

    static boolean isSafe(int row, int col, char[][] board, int n) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        for (int i = row-1, j = col-1; i >=0 && j >=0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row-1, j = col+1; i >=0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    static void solve(int row, char[][] board, List<List<String>> res, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++)
                solution.add(new String(board[i]));
            res.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(row+1, board, res, n);
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');
        List<List<String>> res = new ArrayList<>();

        solve(0, board, res, n);

        for (List<String> solution : res) {
            for (String row : solution)
                System.out.println(row);
            System.out.println();
        }

        System.out.println("Total solutions: " + res.size());
        sc.close();
    }
}
