#include <bits/stdc++.h>
using namespace std;

vector<int> mergeSortedArrays(const vector<int>& arr1, const vector<int>& arr2) {
    vector<int> mergedArray;
    int i = 0, j = 0;
    while (i < arr1.size() && j < arr2.size()) {
        if (arr1[i] <= arr2[j]) {
            mergedArray.push_back(arr1[i]);
            i++;
        } else {
            mergedArray.push_back(arr2[j]);
            j++;
        }
    }
    while (i < arr1.size()) {
        mergedArray.push_back(arr1[i]);
        i++;
    }
    while (j < arr2.size()) {
        mergedArray.push_back(arr2[j]);
        j++;
    }
    return mergedArray;
}

int main() {
    int n1, n2;
    cin >> n1;
    vector<int> arr1(n1);
    for (int i = 0; i < n1; ++i) {
        cin >> arr1[i];
    }
    cin >> n2;
    vector<int> arr2(n2);
    for (int i = 0; i < n2; ++i) {
        cin >> arr2[i];
    }
    vector<int> mergedArray = mergeSortedArrays(arr1, arr2);
    for (int num : mergedArray) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
