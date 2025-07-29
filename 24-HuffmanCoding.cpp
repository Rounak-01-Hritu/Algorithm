#include <bits/stdc++.h>
using namespace std;

struct Node {
    char ch;
    int freq;
    Node *left, *right;
    Node(char ch, int freq) : ch(ch), freq(freq), left(NULL), right(NULL) {}
};

struct compare {
    bool operator()(Node* l, Node* r) {
        return l->freq > r->freq; // min-heap
    }
};

void printCodes(Node* root, string str) {
    if (!root) return;
    if (root->ch != '$') // '$' denotes internal nodes
        cout << root->ch << ": " << str << endl;
    printCodes(root->left, str + "0");
    printCodes(root->right, str + "1");
}

void HuffmanCodes(vector<char>& chars, vector<int>& freq) {
    priority_queue<Node*, vector<Node*>, compare> minHeap;

    for (int i = 0; i < chars.size(); i++)
        minHeap.push(new Node(chars[i], freq[i]));

    while (minHeap.size() > 1) {
        Node* left = minHeap.top(); minHeap.pop();
        Node* right = minHeap.top(); minHeap.pop();

        Node* newNode = new Node('$', left->freq + right->freq);
        newNode->left = left;
        newNode->right = right;
        minHeap.push(newNode);
    }

    printCodes(minHeap.top(), "");
}

int main() {
    int n;
    cout << "Enter number of characters: ";
    cin >> n;
    vector<char> chars(n);
    vector<int> freq(n);

    cout << "Enter characters: ";
    for (int i = 0; i < n; i++) cin >> chars[i];

    cout << "Enter frequencies: ";
    for (int i = 0; i < n; i++) cin >> freq[i];

    cout << "Huffman Codes:\n";
    HuffmanCodes(chars, freq);
    return 0;
}
