#include <bits/stdc++.h>
using namespace std;

void generateDoublyEvenMagicSquare(int n) {
    if (n % 4 != 0) {
        cout << "This method only works for doubly even (multiple of 4) n." << endl;
        return;
    }

    vector<vector<int>> magic(n, vector<int>(n));
    int num = 1;
    int num2 = n * n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if ((i % 4 == j % 4) || ((i % 4 + j % 4) == 3))
                magic[i][j] = num2;
            else
                magic[i][j] = num;
            num++;
            num2--;
        }
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
    cout << "Enter doubly even size of magic square (multiple of 4): ";
    cin >> n;
    generateDoublyEvenMagicSquare(n);
    return 0;
}
