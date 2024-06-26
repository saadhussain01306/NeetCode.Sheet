/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>res=new ArrayList<>();
        Queue<Node>que=new LinkedList<>();
        if(root==null){
            return res;
        }
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer>cur_list=new ArrayList<>();
            
            int len=que.size();
            for(int i=0;i<len;i++){
                Node cur_node=que.poll();
                cur_list.add(cur_node.val);
                for(Node j:cur_node.children){
                    que.offer(j);
                }
            }
            res.add(cur_list);
        }

        return res;
    }
}
