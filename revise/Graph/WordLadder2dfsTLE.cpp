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

    void dfs(int curr, int target, vector<bool> &visited, vector<int> &temp, vector<vector<int> > &result, vector<vector<int> > &adjList){
        if(curr == target){
           temp.push_back(target);
           if(result.size() == 0  ) result.push_back(temp);
           else if(result[0].size() == temp.size()) result.push_back(temp);
           else if(result[0].size() > temp.size()) result = {temp};
            temp.pop_back();
        }
        if(visited[curr]) return;;
        visited[curr] = true;
        temp.push_back(curr);
        for(int i : adjList[curr]){
            dfs(i, target, visited, temp, result, adjList);
        }
        temp.pop_back();
        visited[curr] = false;
    }

    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        int n = wordList.size();
        vector<vector<int>> adjList(n+1,  vector<int>());
        int target = -1;
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
        }
        if(target == -1) return {{}};
        
        
        vector<vector<int>> res;        
        vector<bool> visited(n, false);
        vector<int> currPath;
        for(int i = 0; i < n; i++){
            if(oneCharDiff(beginWord, wordList[i])){
                dfs(i, target, visited, currPath, res, adjList);
            } 
        }
        vector<vector<string>> ans(res.size(), vector<string>());
        for(int i = 0; i < res.size(); i++){
            ans[i].push_back(beginWord);
            for(int j =0; j < res.size(); j++){
                ans[i].push_back(wordList[res[i][j]]);
            }
        }
        return ans;  
    }
};