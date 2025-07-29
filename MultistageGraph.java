import java.util.*;

public class MultistageGraph {
    static final int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int n = sc.nextInt();
        int e = sc.nextInt();

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v w):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new int[]{v, w});
        }

        int[] cost = new int[n+1];
        Arrays.fill(cost, INF);
        cost[n] = 0;

        for (int i = n-1; i >= 1; i--) {
            for (int[] edge : adj.get(i)) {
                int v = edge[0], w = edge[1];
                cost[i] = Math.min(cost[i], w + cost[v]);
            }
        }

        System.out.println("Minimum cost from 1 to " + n + " = " + cost[1]);
        sc.close();
    }
}
