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


class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> res= new ArrayList<>();

        HashMap<String,Integer> map1= new HashMap<>();
        HashMap<String,Integer> map2= new HashMap<>();

        count(s1,map1);
        count(s2,map2);

        //count the uncommon words in s1

        for(Map.Entry<String,Integer> entry:map1.entrySet()){
            if(entry.getValue()==1 && !map2.containsKey(entry.getKey())){
                res.add(entry.getKey());
            }
        }

        //count the uncommon words in s2

        for(Map.Entry<String,Integer> entry:map2.entrySet()){
            if(entry.getValue()==1 && !map1.containsKey(entry.getKey())){
                res.add(entry.getKey());
            }
        }

        return res.toArray(new String[0]);
        
    }

    private void count(String s,HashMap<String,Integer>map){
        String[] str=s.split(" ");

        for(String st: str){
            map.put(st,map.getOrDefault(st,0)+1);
        }
    }

}
