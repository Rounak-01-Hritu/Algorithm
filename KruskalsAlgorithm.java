import java.util.*;

class Edge {
    int u, v, weight;
    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

public class KruskalsAlgorithm {

    static int findParent(int v, int[] parent) {
        if (v == parent[v]) return v;
        return parent[v] = findParent(parent[v], parent);
    }

    static void unionSet(int a, int b, int[] parent, int[] rank) {
        a = findParent(a, parent);
        b = findParent(b, parent);
        if (a != b) {
            if (rank[a] < rank[b]) {
                int temp = a; a = b; b = temp;
            }
            parent[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
        }
    }

    static void kruskal(List<Edge> edges, int V) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        List<Edge> result = new ArrayList<>();
        int totalWeight = 0;

        for (Edge e : edges) {
            if (findParent(e.u, parent) != findParent(e.v, parent)) {
                result.add(e);
                totalWeight += e.weight;
                unionSet(e.u, e.v, parent, rank);
            }
        }

        System.out.println("Edges in MST:");
        for (Edge e : result)
            System.out.println(e.u + " - " + e.v + "   " + e.weight);
        System.out.println("Total weight: " + totalWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Edge> edges = new ArrayList<>();

        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(u, v, weight));
        }

        kruskal(edges, V);
        sc.close();
    }
}
