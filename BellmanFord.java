import java.util.*;

class Edge {
    int u, v, w;
    Edge(int u, int v, int w) {
        this.u = u; this.v = v; this.w = w;
    }
}

public class BellmanFord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            edges[i] = new Edge(u, v, w);
        }

        int src = sc.nextInt();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i <= V - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        boolean negativeCycle = false;
        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                negativeCycle = true;
                break;
            }
        }

        if (negativeCycle) {
            System.out.println("Graph contains a negative weight cycle");
        } else {
            System.out.println("Vertex Distance from Source");
            for (int i = 0; i < V; i++) {
                if (dist[i] == Integer.MAX_VALUE)
                    System.out.println(i + " \t INF");
                else
                    System.out.println(i + " \t " + dist[i]);
            }
        }
        sc.close();
    }
}
