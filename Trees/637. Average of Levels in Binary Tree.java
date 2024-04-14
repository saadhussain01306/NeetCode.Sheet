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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            double sum=0;
            int nodes=0;
            int cur_size=q.size();

            for(int i=0;i<cur_size;i++){
                TreeNode cur_node=q.poll();
                sum+=cur_node.val;
                nodes++;

                if(cur_node.left!=null){
                    q.offer(cur_node.left);
                }
                 if(cur_node.right!=null){
                    q.offer(cur_node.right);
                }
            }
            res.add(sum/nodes);
        }

        return res; 
    }
}
