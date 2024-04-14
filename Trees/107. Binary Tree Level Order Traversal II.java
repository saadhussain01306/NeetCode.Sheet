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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int level_size=q.size();
            List<Integer>curr_level_list=new ArrayList<>();
            
            for(int i=0;i<level_size;i++){
                TreeNode cur=q.poll();
                curr_level_list.add(cur.val);

                if(cur.left!=null){
                    q.offer(cur.left);
                }

                if(cur.right!=null){
                    q.offer(cur.right);
                }

            }
            res.add(0,curr_level_list);//append this to the first position.
        }

        return res;
    }
}
