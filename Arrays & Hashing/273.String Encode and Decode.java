/*
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]
Constraints:

0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains only UTF-8 characters.
*/

class Solution {

    public String encode(List<String> strs) {
       StringBuilder res= new StringBuilder();

       for(String s:strs){
        res.append(s.length()).append('#').append(s);
       }
       return res.toString();
    }

    public List<String> decode(String str) {
       List<String> res= new ArrayList<>();
        int i=0;
       while(i<str.length()){
          int j=i;
          while(str.charAt(j)!='#') j++;//to calculate the number is it is 2 or nor digist as well

          int length=Integer.valueOf(str.substring(i,j));

           i=j+1+length;

          res.add(str.substring(j+1,i));
       }

       return res;
    }
}
