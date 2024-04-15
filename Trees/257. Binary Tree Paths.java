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
    List<String>res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {     
        get_list(root,"",res);
        return res;
    }
    private void get_list(TreeNode node,String path,List<String>res){
        if(node==null){
            return;
        }
        if(!path.isEmpty()){
            path+="->"+node.val;
        }
        else{
            path=String.valueOf(node.val);
        }
        //check leaf
        if(node.left==null && node.right==null){
            res.add(path);
            return;
        }

        get_list(node.left,path,res);
        get_list(node.right,path,res);
    }
}
