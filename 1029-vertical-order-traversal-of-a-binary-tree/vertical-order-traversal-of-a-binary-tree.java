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

class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node,int _row,int _col){
        node = _node;
        row = _row;
        col = _col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root,0,0));
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }

            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if(node.left!=null) queue.offer(new Tuple(node.left,x-1,y+1));
            if(node.right!=null) queue.offer(new Tuple(node.right,x+1,y+1));
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> y : map.values()){
            result.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : y.values()){
                while(!nodes.isEmpty()){
                    result.get(result.size()-1).add(nodes.poll());
                }
            }
        }
        return result;
    }
}