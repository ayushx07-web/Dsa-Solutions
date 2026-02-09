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

   
    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildTree(0, list.size() - 1);
    }

    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

   
    private TreeNode buildTree(int left, int right) {

        if (left > right) return null;
        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildTree(left, mid - 1);
        node.right = buildTree(mid + 1, right);

        return node;
    }
}
