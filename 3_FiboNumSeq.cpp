//fibonacci series
#include <bits/stdc++.h>
using namespace std;

void printFibonacci(int n) {
    long long a = 0, b = 1;
    cout << a << " " << b << " ";
    for (int i = 2; i < n; i++) {
        long long c = a + b;
        cout << c << " ";
        a = b;
        b = c;
    }
    cout << endl;
}

int main() {
    int n;
    cout << "Enter how many terms: ";
    cin >> n;
    printFibonacci(n);
    return 0;
}
