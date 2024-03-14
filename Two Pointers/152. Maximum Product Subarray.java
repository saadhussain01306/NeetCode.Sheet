class Solution {
    public int maxProduct(int[] nums) {
       int left_prod=1;
       int goal=nums[0];
       int right_prod=1;
       int n=nums.length;

       for(int i=0;i<n;i++){
           
           if(left_prod==0){
            left_prod=1;
           }
           if(right_prod==0){
            right_prod=1;
           }
           left_prod*=nums[i];
           right_prod*=nums[n-i-1];

           goal=Math.max(goal,Math.max(left_prod,right_prod));
       }

       return goal; 
    }
}
