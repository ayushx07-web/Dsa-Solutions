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
     private void parents(TreeNode root,Map<TreeNode,TreeNode> parentmap,TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            if(current.left!=null){
                parentmap.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right!=null){
                parentmap.put(current.right,current);
                q.offer(current.right);
            }
        }
     }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentmap = new HashMap<>();
        parents(root,parentmap,root);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(dist==k) break;
            dist++;
            for(int i=0;i<size;i++){
            TreeNode current = q.poll();
            if(current.left!=null &&  !visited.containsKey(current.left)){
                q.offer(current.left);
                visited.put(current.left,true);
            }
            
            if(current.right!=null && !visited.containsKey(current.right)){
                q.offer(current.right);
                visited.put(current.right,true);
            }

            if(parentmap.containsKey(current) && !visited.containsKey(parentmap.get(current))){
                q.offer(parentmap.get(current));
                visited.put(parentmap.get(current),true);
            }

            }
        }

        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            list.add(current.val);
        }
        return list;
    }
}