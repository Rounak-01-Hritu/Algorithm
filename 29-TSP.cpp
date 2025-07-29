// C++ - Traveling Salesman Problem (TSP) using bitmask DP
#include <bits/stdc++.h>
using namespace std;

int tsp(int pos, int mask, vector<vector<int>>& dist, vector<vector<int>>& dp) {
    int n = dist.size();
    if (mask == (1 << n) - 1) return dist[pos][0];
    if (dp[pos][mask] != -1) return dp[pos][mask];

    int ans = INT_MAX;
    for (int nxt = 0; nxt < n; nxt++) {
        if ((mask & (1 << nxt)) == 0) {
            int newAns = dist[pos][nxt] + tsp(nxt, mask | (1 << nxt), dist, dp);
            ans = min(ans, newAns);
        }
    }
    return dp[pos][mask] = ans;
}

int main() {
    int n; 
    cin >> n;
    vector<vector<int>> dist(n, vector<int>(n));
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> dist[i][j];

    vector<vector<int>> dp(n, vector<int>(1 << n, -1));
    cout << tsp(0, 1, dist, dp) << "\n";

    return 0;
}
