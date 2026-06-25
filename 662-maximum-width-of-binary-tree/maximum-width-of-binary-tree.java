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
 class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode _node,int _num){
        node = _node;
        num = _num;
    }
 }


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        if(root==null) return result;
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int first = 0,last = 0;
            int min = queue.peek().num;
           
            for(int i=0;i<size;i++){
                 int curidx = queue.peek().num-min;
                 TreeNode node = queue.peek().node;
                 queue.poll();

                 if(i==0) first = curidx;
                 if(i==size-1) last = curidx;

                 if(node.left!=null) queue.offer(new Pair(node.left,2*curidx+1));
                 if(node.right!=null) queue.offer(new Pair(node.right,2*curidx+2));
            }
          result = Math.max(result,last-first+1);
        }
          return result;
    }
}