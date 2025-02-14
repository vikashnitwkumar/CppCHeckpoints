#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    bool oneCharDiff(string &a, string &b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a[i]!= b[i]) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }

    

    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        int n = wordList.size();
        vector<vector<int>> adjList(n+1,  vector<int>());
        int target = -1;
        int start = -1;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(oneCharDiff(wordList[i], wordList[j])){
                    adjList[i].push_back(j);
                    adjList[j].push_back(i);
                }
            }
            if(wordList[i] == endWord){
                target = i;
            }
            if(wordList[i] == beginWord){
                start = i;
            }
        }
        vector<vector<string>> ans;
        if(target == -1) return ans;
        
        
        vector<vector<int>> res;        
        vector<bool> visited(n, false);
        if(start != -1)  visited[start] = true;
        queue<pair<int, vector<int>>> q;
        for(int i = 0; i < n; i++){
            if(oneCharDiff(beginWord, wordList[i])){
                q.push({i, {start}});
                //dfs(i, target, visited, currPath, res, adjList);
            } 
        }
        bool found = false;
        while(!q.empty() && !found){
            int n = q.size();
            while(n--){
                auto p = q.front();
                q.pop();
                visited[p.first] = true;                
                vector<int> temp = p.second;
                temp.push_back(p.first);
                if(p.first == target) {
                    found = true;
                    res.push_back(temp);
                    continue;
                }
                for(int itr : adjList[p.first]){
                    if(!visited[itr]){
                        q.push({itr, temp});
                    }
                }
            }
        }
         ans.resize(res.size(), vector<string>());
        for(int i = 0; i < res.size(); i++){
            for(int j =0; j < res.size(); j++){
                if(res[i][j] == -1){                    
                    ans[i].push_back(beginWord);
                }
                ans[i].push_back(wordList[res[i][j]]);
            }
        }
        return ans;  
    }
};