/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        if(root==null) return null;
        if(curr.val>p.val && curr.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(curr.val<p.val && curr.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}