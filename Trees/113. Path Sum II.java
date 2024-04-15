/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        get_sum(root,targetSum,new ArrayList<>());
        return res;
    }

    private void get_sum(TreeNode node, int target,List<Integer>cur_list){
        if(node==null){
            return;
        }
        cur_list.add(node.val);
        if(node.left==null && node.right==null){
            int sum=0;
            for(int i:cur_list){
                sum+=i;
            }
                if(sum==target){
                    res.add(new ArrayList<>(cur_list)); // Add a copy of curList
                }
            
        }

        get_sum(node.left,target,new ArrayList<>(cur_list));
        get_sum(node.right,target,new ArrayList<>(cur_list));
    }
}
