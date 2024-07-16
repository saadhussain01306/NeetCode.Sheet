/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 /*
         

1. Apply DFS.
2. If you find any one of the target node, return the node itself.
3. If any subtree return a NON- NULL Node, the return the NON- NULL Node.
4. If both the subtree returns the NON-NULL value, then it is LCA, return the Node itself.
5. If both the subtree returns NULL
then return NULL.
        */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode left_child=lowestCommonAncestor(root.left,p,q);
        TreeNode right_child=lowestCommonAncestor(root.right,p,q);

        if(left_child==null){
            return right_child;
        }
        else if(right_child==null){
            return left_child;
        }
        else{
            return root;
        }
    }
}
