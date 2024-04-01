#include <bits/stdc++.h>
using namespace std;

int lowerBound(const vector<int>& arr, int x) {
    int left = 0, right = arr.size() - 1;
    int lower_bound_id = -1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] >= x) {
            lower_bound_id = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return lower_bound_id;
}

int upperBound(const vector<int>& arr, int x) {
    int left = 0, right = arr.size() - 1;
    int upper_bound_idx = -1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] > x) {
            upper_bound_idx = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return upper_bound_idx;
}

bool isPresent(const vector<int>& arr, int x) {
    int left = 0, right = arr.size() - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == x) {
            return true;
        } else if (arr[mid] < x) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return false;
}

int main() {
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }
    int x;
    cin >> x;
    int lower = lowerBound(arr, x);
    int upper = upperBound(arr, x);
    bool present = isPresent(arr, x);
	
	cout << lower << "\n" << upper << "\n" << present << "\n";

    return 0;
}
