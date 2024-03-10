class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n=temp.length;
        int ans[]=new int[n];

        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temp[i]>=temp[st.peek()]){
                st.pop();
            }
             // we are left out with the higher temperature
            if(!st.isEmpty()){
               ans[i]=st.peek()-i;
            }

            st.push(i);
        }

        return ans;
    }
}
