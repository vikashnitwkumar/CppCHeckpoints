#include<bits/stdc++.h>
using namespace std;

class Solution {
    public:
    string getHappyString(int n, int k) {
        if(n==0) return "";
        int totalpossible = 3*(1<<n-1);
        if(totalpossible < k) return "";
        string ans = "";
        k--;
        string s = "";
        int temp = k / (1<<n-1);
        k = k % (1<<n-1);
        s = 'a' + temp;
        for(int i=1; i<n; i++){
            temp = k / (1<<n-1-i);
            k = k % (1<<n-i-1);
            temp += (s[i-1] - 'a') + 1;
            temp %= 3;
            s += 'a' + temp;
        }
        return s;
    }
};