#include <bits/stdc++.h>
using namespace std;

#define INF 1e9

int main() {
    int n, e;
    cout << "Enter number of vertices and edges: ";
    cin >> n >> e;

    vector<vector<pair<int,int>>> adj(n+1);

    cout << "Enter edges (u v w):\n";
    for (int i = 0; i < e; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
    }

    vector<int> cost(n+1, INF);
    cost[n] = 0; // destination cost = 0

    for (int i = n-1; i >= 1; i--) {
        for (auto [v, w] : adj[i]) {
            cost[i] = min(cost[i], w + cost[v]);
        }
    }

    cout << "Minimum cost from 1 to " << n << " = " << cost[1] << endl;
    return 0;
}
