class Solution {
    public int maximumGain(String s, int x, int y) {
        boolean flag=false;
        int ans=0;
        if(x>y){
            ans+=compute(s,'a','b',x,y);

        }
        else{
            ans+=compute(s,'b','a',y,x);
        }
        
        return ans;
        
    }
    private int compute(String s ,char first,char sec,int highpoints,int lowpoints){
        int ans=0;
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!st.isEmpty() && st.peek()==first && ch==sec){
                ans+=highpoints;
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder str=new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        String s1=str.reverse().toString();
         st.clear();//clear stack contents
        for(char ch:s1.toCharArray()){
            if(!st.isEmpty() && st.peek()==sec && ch==first){
                ans+=lowpoints;
                st.pop();
            }
            else{
                st.push(ch);
            }
        }

        return ans;
    }
}
