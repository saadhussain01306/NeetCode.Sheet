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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return dfs(root,val,depth,1);//last parameter is the current depth i.e 1
    }
    private TreeNode dfs(TreeNode root, int val, int depth,int cur_depth){
        if(depth==1){
            TreeNode first=new TreeNode(val);
            first.left=root;
            return first;//now first is the root of the subtree 
        }

        if(root==null){
            return root;
        }

        if(cur_depth==depth-1){
            //store addresses of the left and right nodes of the nodes 

         TreeNode left_add=root.left;
         TreeNode right_add=root.right;

         //add the new addresses for theleft and right nodes of the root i.e the va;ues of the nodes
         root.left=new TreeNode(val);
         root.right=new TreeNode(val);

         root.left.left=left_add;
         root.right.right=right_add;

         return root;


        }

         dfs(root.left,val,depth,cur_depth+1);
         dfs(root.right,val,depth,cur_depth+1);

        return root;
    }
}
