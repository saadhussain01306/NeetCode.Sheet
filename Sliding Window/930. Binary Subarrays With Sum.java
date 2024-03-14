class Solution {
    public int numSubarraysWithSumAtmostK(int[] nums, int goal) {
        // find subarrays with atmost goal sums-subarrays with atmost (goal-1) sums
        int start=0;
        int  end=0;
        int count=0;
        int sum=0;
        for(end=0;end<nums.length;end++){
            sum+=nums[end];//expand window

            while(start<=end && sum>goal){
                sum-=nums[start];////shrink
                start++;
            }
            count+=(end-start+1);
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumAtmostK(nums,goal)-numSubarraysWithSumAtmostK(nums, goal-1);
    }
}
