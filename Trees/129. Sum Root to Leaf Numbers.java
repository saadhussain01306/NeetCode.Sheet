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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        get_sum(root,0);//initially the cur_sum is 0
        return sum;
    }
    private void get_sum(TreeNode node,int cur_sum){

        if(node==null){
            return;//base case
        }
        cur_sum=(cur_sum*10)+node.val;

        if(node.left==null && node.right==null){
            sum+=cur_sum;//add the current sum to the global variable sum;
            return;
        }

        get_sum(node.left,cur_sum);
        get_sum(node.right,cur_sum);
    }
}
