class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans=new int[2];
       int i,j;
       int len=nums.length;
       for(i=0;i<len;i++){
         for(j=i+1;j<len;j++){
             if(nums[i]+nums[j]==target){
                 ans[0]=i;
                 ans[1]=j;
                 return ans;
             }
         }
       } 
       return ans;
    }
}
