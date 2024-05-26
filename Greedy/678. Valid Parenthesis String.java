/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.
*/

class Solution {
    public boolean checkValidString(String s) {
        int len=s.length();
        if(len==0){
            return true;
        }
        Stack<Integer>left_brace=new Stack<>();
        Stack<Integer>star=new Stack<>();
        for(int i=0;i<len;i++){
              char c=s.charAt(i);
              if(c=='('){
                left_brace.push(i);//push the index of the brace
              }
              else if(c=='*'){
                star.push(i);//push the index of the star
              }
              else{
                if(!left_brace.isEmpty()){
                    left_brace.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }
                else{
                    return false;
                    //there is no opening or start for the ')' braces
                }
              }

        }

        //now handle the remaining '('

              while(!left_brace.isEmpty() && !star.isEmpty()){
                if(left_brace.peek()<star.peek()){
                    left_brace.pop();
                    star.pop();
                }
                else{
                    return false;//no matching '(' for "*"
                }
              }

              return left_brace.isEmpty();

        
    }
}
