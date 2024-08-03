/*
Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

 

Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
Example 2:

Input: words = ["omk"]
Output: []
Example 3:

Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]
 

Constraints:

1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] consists of English letters (both lowercase and uppercase). 

*/


class Solution {
    public String[] findWords(String[] words) {
        List<String> res= new ArrayList<>();

        String s1="qwertyuiop";
        String s2="asdfghjkl";
        String s3="zxcvbnm";

        for(String s:words){
            int s_length=s.length();
            int l1=0;int l2=0;int l3=0;
            for(int i=0;i<s_length;i++){
                char a=Character.toLowerCase(s.charAt(i));
                if(s1.contains(a+"")) l1++;
                if(s2.contains(a+"")) l2++;
                if(s3.contains(a+"")) l3++;//contains accepts a string not a character so append charcter with empty string ""
            }

            if(s_length==l1 || s_length==l2 || s_length==l3){
                res.add(s);
            }
        }
        String[] ans= new String[res.size()];
        ans=res.toArray(ans);
        return ans;
    }
}
