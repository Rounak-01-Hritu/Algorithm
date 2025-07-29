import java.util.*;

class Graph {
    int V;
    int[][] adjMatrix;
    ArrayList<ArrayList<Integer>> adjList;

    Graph(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        // Adjacency Matrix
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // For undirected graph

        // Adjacency List
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    void displayMatrix() {
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                System.out.print(adjMatrix[i][j] + " ");
            System.out.println();
        }
    }

    void displayList() {
        System.out.println("\nAdjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int v : adjList.get(i))
                System.out.print(v + " ");
            System.out.println();
        }
    }
}

public class GraphRepresentation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        Graph g = new Graph(V);

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        g.displayMatrix();
        g.displayList();

        sc.close();
    }
}
