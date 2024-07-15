/*
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

 

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*/



class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list= new ArrayList<>();

        for(int i=0;i<s.length();){
            int startIndex=i;
            int endIndex=s.lastIndexOf(s.charAt(startIndex));
            //now we have first and last indecies of the letters

            for(int j=startIndex+1;j<=endIndex-1;j++){
                int lastIndexOfNextCharacter=s.lastIndexOf(s.charAt(j));
                if(lastIndexOfNextCharacter>endIndex){
                    endIndex=lastIndexOfNextCharacter;
                }
            }

            list.add(endIndex-startIndex+1);
            i=endIndex+1;
        }

        return list;
    }
}
