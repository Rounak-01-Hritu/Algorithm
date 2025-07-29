// Java - DFS
import java.util.*;

public class DFS {

    static void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // remove if directed graph
        }

        int start = sc.nextInt();
        boolean[] visited = new boolean[V];

        dfs(start, adj, visited);

        sc.close();
    }
}
