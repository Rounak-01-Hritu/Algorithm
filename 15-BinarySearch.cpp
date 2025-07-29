#include <bits/stdc++.h>
using namespace std;

// Iterative Binary Search
int binarySearchIterative(vector<int>& arr, int key) {
    int low = 0, high = arr.size() - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == key)
            return mid;
        else if (arr[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}

// Recursive Binary Search
int binarySearchRecursive(vector<int>& arr, int low, int high, int key) {
    if (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == key)
            return mid;
        else if (arr[mid] < key)
            return binarySearchRecursive(arr, mid + 1, high, key);
        else
            return binarySearchRecursive(arr, low, mid - 1, key);
    }
    return -1;
}

int main() {
    int n, key;
    cout << "Enter number of elements: ";
    cin >> n;
    vector<int> arr(n);

    cout << "Enter elements in sorted order: ";
    for (int i = 0; i < n; i++) cin >> arr[i];

    cout << "Enter element to search: ";
    cin >> key;

    int result = binarySearchIterative(arr, key);
    if (result != -1)
        cout << "Element found at index " << result << " (iterative)\n";
    else
        cout << "Element not found (iterative)\n";

    result = binarySearchRecursive(arr, 0, n - 1, key);
    if (result != -1)
        cout << "Element found at index " << result << " (recursive)\n";
    else
        cout << "Element not found (recursive)\n";

    return 0;
}
