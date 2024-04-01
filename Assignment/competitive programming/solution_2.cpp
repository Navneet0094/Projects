#include <bits/stdc++.h>
using namespace std;

vector<int> sieve(int limit) {
    vector<bool> isPrime(limit + 1, true);
    vector<int> primes;
    for (int p = 2; p * p <= limit; ++p) {
        if (isPrime[p]) {
            for (int i = p * p; i <= limit; i += p) {
                isPrime[i] = false;
            }
        }
    }
    for (int p = 2; p <= limit; ++p) {
        if (isPrime[p]) {
            primes.push_back(p);
        }
    }
    return primes;
}

int main() {
    int N;
    cin >> N;
    vector<int> primes = sieve(1000000);
    for (int i = 0; i < 2 * N; i += 2) {
        cout << primes[i] << " ";
    }
    cout << endl;
    return 0;
}
