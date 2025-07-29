#include <bits/stdc++.h>
using namespace std;

class Graph {
    int V; 
    vector<vector<int>> adjMatrix;
    vector<vector<int>> adjList;

public:
    Graph(int V) {
        this->V = V;
        adjMatrix = vector<vector<int>>(V, vector<int>(V, 0));
        adjList = vector<vector<int>>(V);
    }

    void addEdge(int u, int v) {
        // Adjacency Matrix
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // For undirected graph

        // Adjacency List
        adjList[u].push_back(v);
        adjList[v].push_back(u);
    }

    void displayMatrix() {
        cout << "\nAdjacency Matrix:\n";
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                cout << adjMatrix[i][j] << " ";
            cout << endl;
        }
    }

    void displayList() {
        cout << "\nAdjacency List:\n";
        for (int i = 0; i < V; i++) {
            cout << i << " -> ";
            for (int v : adjList[i])
                cout << v << " ";
            cout << endl;
        }
    }
};

int main() {
    int V, E;
    cout << "Enter number of vertices: ";
    cin >> V;
    cout << "Enter number of edges: ";
    cin >> E;

    Graph g(V);

    cout << "Enter edges (u v):\n";
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        g.addEdge(u, v);
    }

    g.displayMatrix();
    g.displayList();

    return 0;
}
