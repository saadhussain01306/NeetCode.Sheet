class Solution {
    public int[] twoSum(int[] n, int target) {
        int [] ans=new int[2];
        
        int left=0;
        int right=n.length-1;

        while(left<right){
            int sum=n[left]+n[right];

            if(sum>target){
                right--;
            }
            else if(sum<target){
                left++;
            }
            else {
               break;
            }
        }

        ans[0]=left+1;
        ans[1]=right+1;

        return ans;
        
    }
}
