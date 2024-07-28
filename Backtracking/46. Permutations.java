/*

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

*/


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // Initialize the result list to store all permutations
        backtrack(res, nums, 0); // Start the backtracking with the initial index 0
        return res; // Return the result list containing all permutations
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) { // If the starting index is equal to the length of nums
            List<Integer> tempList = new ArrayList<>(); // Create a temporary list to store the current permutation
            for (int num : nums) {
                tempList.add(num); // Add each element of nums to the temporary list
            }
            res.add(tempList); // Add the temporary list to the result list
            return;
        }
        for (int i = start; i < nums.length; i++) { // Iterate over the elements starting from index 'start'
            swap(nums, start, i); // Swap the current element with the element at the 'start' index
            backtrack(res, nums, start + 1); // Recursively call backtrack with the next starting index
            swap(nums, start, i); // Swap back to backtrack and explore other permutations
        }
    }

    private void swap(int[] nums, int i, int j) { // Helper function to swap elements at indices i and j
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
