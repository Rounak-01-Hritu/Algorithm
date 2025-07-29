#include <bits/stdc++.h>
using namespace std;

struct Item {
    int value, weight;
};

bool cmp(Item a, Item b) {
    double r1 = (double)a.value / a.weight;
    double r2 = (double)b.value / b.weight;
    return r1 > r2;
}

double fractionalKnapsack(int W, vector<Item>& items, int n) {
    sort(items.begin(), items.end(), cmp);

    double finalValue = 0.0;
    for (int i = 0; i < n; i++) {
        if (items[i].weight <= W) {
            W -= items[i].weight;
            finalValue += items[i].value;
        } else {
            finalValue += items[i].value * ((double)W / items[i].weight);
            break;
        }
    }
    return finalValue;
}

int main() {
    int n, W;
    cout << "Enter number of items: ";
    cin >> n;
    vector<Item> items(n);

    cout << "Enter values of items: ";
    for (int i = 0; i < n; i++) cin >> items[i].value;

    cout << "Enter weights of items: ";
    for (int i = 0; i < n; i++) cin >> items[i].weight;

    cout << "Enter capacity of knapsack: ";
    cin >> W;

    cout << "Maximum value in Knapsack = " 
         << fractionalKnapsack(W, items, n) << endl;
    return 0;
}
