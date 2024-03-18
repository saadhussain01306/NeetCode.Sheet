class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int final_pos=n-1;

        for(int i=n-2;i>=0;i--){
            // start from the last
            if(i+nums[i]>=final_pos){
                final_pos=i;//update the index to the final_pos to the index from where it can be reached
            }
        }

        return final_pos==0;//true if all the stairs can be reached 
    }
}
