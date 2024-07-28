class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); // Initialize the result list to store all combinations
        backtrack(res, new ArrayList<>(), candidates, target, 0); // Start the backtracking with an empty temp_list and start index 0
        return res; // Return the result list containing all combinations
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp_list, int[] candidates, int remain, int start) {
        if (remain < 0) return; // If the remaining target is less than 0, return immediately (pruning)
        if (remain == 0) { // If the remaining target is 0, add the current temp_list to the result list
            res.add(new ArrayList<>(temp_list));
            return;
        }
        for (int i = start; i < candidates.length; i++) { // Iterate over the elements starting from index 'start'
            temp_list.add(candidates[i]); // Add the current element to the temp_list
            backtrack(res, temp_list, candidates, remain - candidates[i], i); // Recursively call backtrack with the updated temp_list, decreased target, and same start index
            temp_list.remove(temp_list.size() - 1); // Remove the last element to backtrack and explore other combinations
        }
    }
}
