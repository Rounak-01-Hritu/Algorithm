#include <bits/stdc++.h>
using namespace std;

// Function to generate odd magic square
vector<vector<int>> generateOddMagicSquare(int n) {
    vector<vector<int>> magic(n, vector<int>(n, 0));
    int i = 0, j = n / 2;
    for (int num = 1; num <= n * n;) {
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
    return magic;
}

void generateSinglyEvenMagicSquare(int n) {
    if (n % 2 != 0 || n % 4 == 0) {
        cout << "This method only works for singly even n (n % 4 == 2)." << endl;
        return;
    }

    int halfN = n / 2;
    int subSquareSize = halfN * halfN;
    vector<vector<int>> subSquare = generateOddMagicSquare(halfN);

    vector<vector<int>> magic(n, vector<int>(n, 0));

    // Fill 4 sub-squares
    for (int i = 0; i < halfN; i++) {
        for (int j = 0; j < halfN; j++) {
            int a = subSquare[i][j];
            magic[i][j] = a;
            magic[i + halfN][j + halfN] = a + subSquareSize;
            magic[i + halfN][j] = a + 2 * subSquareSize;
            magic[i][j + halfN] = a + 3 * subSquareSize;
        }
    }

    // Swap columns
    int k = (n - 2) / 4;
    for (int i = 0; i < halfN; i++) {
        for (int j = 0; j < k; j++) {
            swap(magic[i][j], magic[i + halfN][j]);
        }
        for (int j = n - k + 1; j < n; j++) {
            swap(magic[i][j], magic[i + halfN][j]);
        }
    }

    // Middle column swap
    for (int i = 0; i < halfN; i++) {
        swap(magic[i][k], magic[i + halfN][k]);
    }

    cout << "Magic Square of size " << n << ":\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            cout << setw(4) << magic[i][j] << " ";
        cout << endl;
    }
}

int main() {
    int n;
    cout << "Enter singly even size of magic square (n % 4 == 2): ";
    cin >> n;
    generateSinglyEvenMagicSquare(n);
    return 0;
}
