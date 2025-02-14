#include<bits/stdc++.h>
using namespace std;


class Solution {

public:
    void helper(string &currword, string &endWord, unordered_set<string>& wordList, vector<string> currseq, vector<vector<string>> result){
        if(currword == endWord ){
            currseq.push_back(currword);
            result.push_back(currseq);
            return;
        }
        if(wordList.find(currword) != wordList.end()){
            return;
        }
        wordList.erase(currword);
        currseq.push_back(currword);
        for(int i = 0; i<currword.length(); i++){
            int currChar = currword[i];
            for(char c = 'a'; c <= 'z'; c++){
                if(currChar == c) continue;
                currword[i] = c;
                helper(currword, endWord, wordList, currseq, result);
            }
        }
        wordList.insert(currword);
        currseq.pop_back();
        return;;
    }
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        if(beginWord == endWord) return {{beginWord, endWord}};
        unordered_set<string> words;
        for(auto itr: wordList){
            words.insert(itr);
        }
        words.insert(beginWord);
        words.insert(endWord);

    }
};