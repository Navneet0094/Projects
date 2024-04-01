#include <bits/stdc++.h>
using namespace std;

int findMode(const vector<int>& nums) {
    int mode = nums.front();
    int max_freq = 0;
    for (int i = 0; i < nums.size(); ++i) {
        int freq = count(nums.begin(), nums.end(), nums[i]);
        if (freq > max_freq) {
            max_freq = freq;
            mode = nums[i];
        }
    }
    return mode;
}

int printStatistics(const vector<int>& nums) {
    int min_val = *min_element(nums.begin(), nums.end());
    int max_val = *max_element(nums.begin(), nums.end());
    int sum = accumulate(nums.begin(), nums.end(), 0);
    double average = static_cast<double>(sum) / nums.size();
    int mode = findMode(nums);

    cout << "min, max, sum, average and mode after addition of " << nums.back() << " is " << min_val << ", " << max_val << ", " << sum << ", " << average << ", " << mode << ".\n";
		 
	return 0;
}

int main() {
    int N;
    cin >> N;
    vector<int> numbers;
    for (int i = 0; i < N; ++i) {
        int num;
        cin >> num;
        numbers.push_back(num);
        printStatistics(numbers);
    }

    return 0;
}
