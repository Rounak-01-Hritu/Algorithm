#include <bits/stdc++.h>
using namespace std;

struct Job {
    char id;
    int deadline;
    int profit;
};

bool compare(Job a, Job b) {
    return a.profit > b.profit;
}

void jobSequencing(Job arr[], int n) {
    sort(arr, arr + n, compare);

    int maxDeadline = 0;
    for (int i = 0; i < n; i++)
        maxDeadline = max(maxDeadline, arr[i].deadline);

    vector<int> slot(maxDeadline + 1, -1);
    vector<char> jobOrder(maxDeadline + 1, '-');
    int totalProfit = 0;

    for (int i = 0; i < n; i++) {
        for (int j = arr[i].deadline; j > 0; j--) {
            if (slot[j] == -1) {
                slot[j] = i;
                jobOrder[j] = arr[i].id;
                totalProfit += arr[i].profit;
                break;
            }
        }
    }

    cout << "Selected jobs: ";
    for (int i = 1; i <= maxDeadline; i++) {
        if (jobOrder[i] != '-') cout << jobOrder[i] << " ";
    }
    cout << "\nTotal Profit: " << totalProfit << endl;
}

int main() {
    int n;
    cout << "Enter number of jobs: ";
    cin >> n;
    Job arr[n];
    cout << "Enter job details (id deadline profit):\n";
    for (int i = 0; i < n; i++)
        cin >> arr[i].id >> arr[i].deadline >> arr[i].profit;

    jobSequencing(arr, n);
    return 0;
}
