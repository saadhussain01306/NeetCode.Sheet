/*

A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

 

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]
 

Constraints:

1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.

*/



#include <iostream>
#include <sstream>
#include <vector>
#include <unordered_map>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        vector<string> res;
        unordered_map<string, int> map1;
        unordered_map<string, int> map2;

        count(s1, map1);
        count(s2, map2);

        // Count the uncommon words in s1
        for (const auto& entry : map1) {
            if (entry.second == 1 && map2.find(entry.first) == map2.end()) {
                res.push_back(entry.first);
            }
        }

        // Count the uncommon words in s2
        for (const auto& entry : map2) {
            if (entry.second == 1 && map1.find(entry.first) == map1.end()) {
                res.push_back(entry.first);
            }
        }

        return res;
    }

private:
    void count(const string& s, unordered_map<string, int>& map) {
        istringstream iss(s);
        string word;
        while (iss >> word) {
            map[word]++;
        }
    }
};
