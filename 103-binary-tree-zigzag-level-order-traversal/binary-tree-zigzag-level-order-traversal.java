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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean LTR = true;

        if(root==null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> sublist = new LinkedList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
               TreeNode node = queue.poll();

               if(LTR){
                sublist.add(node.val);
               }else{
                sublist.add(0,node.val);
               }
               if(node.left!=null) queue.offer(node.left);
               if(node.right!=null) queue.offer(node.right);

            }
            LTR= !LTR;
            result.add(sublist);

        }
        return result;
    }
}