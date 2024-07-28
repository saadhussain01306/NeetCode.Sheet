/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(res,new StringBuilder(),0,0,n);
        return res;
    }
    private void backtrack( List<String> res,StringBuilder sb,int open_count,int close_count,int size){
        //base case
        if(sb.length()==size*2){
            res.add(sb.toString());
            return;
        }

        if(open_count<size){
            sb.append('(');
            backtrack(res,sb,open_count+1,close_count,size);
            sb.deleteCharAt(sb.length()-1);//backtrack to delete the 
        }
        if(close_count<open_count){
            sb.append(')');
            backtrack(res,sb,open_count,close_count+1,size);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
