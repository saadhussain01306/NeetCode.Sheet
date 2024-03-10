class Solution {
    public int missingNumber(int[] nums) {
       int n = nums.length;
        
        // Initialize goal to n as it is the maximum possible missing number
        int goal = n;
        
        // XOR ith value with the nums[i] value ,we will be left out with 
        // only the missing number in the goal; 
        for (int i = 0; i < n; i++) {
            goal ^= i ^ nums[i];
        }
        
        return goal;
    }
}
