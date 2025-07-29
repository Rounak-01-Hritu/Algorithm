#include <bits/stdc++.h>
using namespace std;

#define INF 1e9

void prims(vector<vector<int>>& graph, int V) {
    vector<int> key(V, INF);  // min edge weight to connect
    vector<int> parent(V, -1); 
    vector<bool> inMST(V, false);

    key[0] = 0; // start from vertex 0

    for (int count = 0; count < V - 1; count++) {
        int u = -1;

        // find min key vertex not yet in MST
        for (int v = 0; v < V; v++) {
            if (!inMST[v] && (u == -1 || key[v] < key[u]))
                u = v;
        }

        inMST[u] = true;

        for (int v = 0; v < V; v++) {
            if (graph[u][v] && !inMST[v] && graph[u][v] < key[v]) {
                parent[v] = u;
                key[v] = graph[u][v];
            }
        }
    }

    cout << "Edge   Weight\n";
    for (int i = 1; i < V; i++)
        cout << parent[i] << " - " << i << "   " << graph[i][parent[i]] << endl;
}

int main() {
    int V;
    cout << "Enter number of vertices: ";
    cin >> V;
    vector<vector<int>> graph(V, vector<int>(V));

    cout << "Enter adjacency matrix (0 if no edge):\n";
    for (int i = 0; i < V; i++)
        for (int j = 0; j < V; j++)
            cin >> graph[i][j];

    prims(graph, V);

    return 0;
}
