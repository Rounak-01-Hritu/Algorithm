#include <bits/stdc++.h>
using namespace std;

void generateMagicSquare(int n) {
    if (n % 2 == 0) {
        cout << "Magic square is only possible for odd n using this method." << endl;
        return;
    }

    vector<vector<int>> magic(n, vector<int>(n, 0));

    int i = 0, j = n / 2; // start from middle of first row
    for (int num = 1; num <= n * n; ) {
        if (i < 0 && j == n) { 
            i += 2;
            j--;
        }
        if (i < 0) i = n - 1;
        if (j == n) j = 0;
        if (magic[i][j] != 0) {
            i += 2;
            j--;
            continue;
        } else {
            magic[i][j] = num++;
        }
        i--;
        j++;
    }

    cout << "Magic Square of size " << n << ":\n";
    for (int x = 0; x < n; x++) {
        for (int y = 0; y < n; y++)
            cout << setw(4) << magic[x][y] << " ";
        cout << endl;
    }
}

int main() {
    int n;
    cout << "Enter odd size of magic square: ";
    cin >> n;
    generateMagicSquare(n);
    return 0;
}
