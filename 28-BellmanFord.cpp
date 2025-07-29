#include <bits/stdc++.h>
using namespace std;

struct Edge {
    int u, v, w;
};

int main() {
    int V, E;
    cin >> V >> E;
    vector<Edge> edges(E);
    for (int i = 0; i < E; i++)
        cin >> edges[i].u >> edges[i].v >> edges[i].w;

    int src;
    cin >> src;
    vector<int> dist(V, INT_MAX);
    dist[src] = 0;

    for (int i = 1; i <= V - 1; i++) {
        for (auto &e : edges) {
            if (dist[e.u] != INT_MAX && dist[e.u] + e.w < dist[e.v]) {
                dist[e.v] = dist[e.u] + e.w;
            }
        }
    }

    // Check for negative weight cycle
    bool negativeCycle = false;
    for (auto &e : edges) {
        if (dist[e.u] != INT_MAX && dist[e.u] + e.w < dist[e.v]) {
            negativeCycle = true;
            break;
        }
    }

    if (negativeCycle) {
        cout << "Graph contains a negative weight cycle\n";
    } else {
        cout << "Vertex Distance from Source\n";
        for (int i = 0; i < V; i++) {
            if (dist[i] == INT_MAX)
                cout << i << " \t INF\n";
            else
                cout << i << " \t " << dist[i] << "\n";
        }
    }

    return 0;
}
