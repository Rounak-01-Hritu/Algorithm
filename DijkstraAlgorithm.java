import java.util.*;

class Pair {
    int vertex, dist;
    Pair(int v, int d) {
        vertex = v; dist = d;
    }
}

public class DijkstraAlgorithm {

    static void dijkstra(int V, List<List<Pair>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.vertex, d = p.dist;
            if (d > dist[u]) continue;

            for (Pair edge : adj.get(u)) {
                int v = edge.vertex, weight = edge.dist;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v w):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // remove if directed
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        dijkstra(V, adj, src);
        sc.close();
    }
}
//single source shortest path