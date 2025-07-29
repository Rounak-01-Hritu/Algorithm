// Java - Traveling Salesman Problem (TSP) using bitmask DP
import java.util.*;

public class TSP {
    static int tsp(int pos, int mask, int[][] dist, int[][] dp) {
        int n = dist.length;
        if (mask == (1 << n) - 1) return dist[pos][0];
        if (dp[pos][mask] != -1) return dp[pos][mask];

        int ans = Integer.MAX_VALUE;
        for (int nxt = 0; nxt < n; nxt++) {
            if ((mask & (1 << nxt)) == 0) {
                int newAns = dist[pos][nxt] + tsp(nxt, mask | (1 << nxt), dist, dp);
                ans = Math.min(ans, newAns);
            }
        }
        return dp[pos][mask] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = sc.nextInt();

        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println(tsp(0, 1, dist, dp));
        sc.close();
    }
}
