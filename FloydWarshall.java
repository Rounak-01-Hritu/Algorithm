import java.util.*;

public class FloydWarshall {
    static final int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++)
            Arrays.fill(dist[i], INF);
        for (int i = 0; i < V; i++) dist[i][i] = 0;

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            dist[u][v] = w;
        }

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) System.out.print("INF ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
