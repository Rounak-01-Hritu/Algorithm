// C++ - N Queens Problem (Backtracking)
#include <bits/stdc++.h>
using namespace std;

bool isSafe(int row, int col, vector<string>& board, int n) {
    for (int i = 0; i < row; i++)
        if (board[i][col] == 'Q') return false;

    for (int i = row-1, j = col-1; i >=0 && j >=0; i--, j--)
        if (board[i][j] == 'Q') return false;

    for (int i = row-1, j = col+1; i >=0 && j < n; i--, j++)
        if (board[i][j] == 'Q') return false;

    return true;
}

void solve(int row, vector<string>& board, vector<vector<string>>& res, int n) {
    if (row == n) {
        res.push_back(board);
        return;
    }

    for (int col = 0; col < n; col++) {
        if (isSafe(row, col, board, n)) {
            board[row][col] = 'Q';
            solve(row+1, board, res, n);
            board[row][col] = '.';
        }
    }
}

int main() {
    int n; cin >> n;
    vector<string> board(n, string(n, '.'));
    vector<vector<string>> res;

    solve(0, board, res, n);

    for (auto &solution : res) {
        for (string &row : solution)
            cout << row << "\n";
        cout << "\n";
    }

    cout << "Total solutions: " << res.size() << "\n";
    return 0;
}
