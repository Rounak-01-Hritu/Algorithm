import java.util.*;

public class PrimsAlgorithm {
    static final int INF = Integer.MAX_VALUE;

    static void prims(int[][] graph, int V) {
        int[] key = new int[V];  
        int[] parent = new int[V]; 
        boolean[] inMST = new boolean[V];

        Arrays.fill(key, INF);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = -1;

            for (int v = 0; v < V; v++) {
                if (!inMST[v] && (u == -1 || key[v] < key[u]))
                    u = v;
            }

            inMST[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "   " + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        int[][] graph = new int[V][V];

        System.out.println("Enter adjacency matrix (0 if no edge):");
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = sc.nextInt();

        prims(graph, V);
        sc.close();
    }
}
