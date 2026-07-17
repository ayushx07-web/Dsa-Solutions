class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adjRev.add(new ArrayList<>());
        }
        int m = graph.length;
        for(int i=0;i<m;i++){
           for(int it : graph[i]){
            adjRev.get(it).add(i);
           }
        }

        int[] indegree = new int[graph.length];
        for(int i=0;i<m;i++){
            for(int it : adjRev.get(i)){
                
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0) q.add(i);
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safeNodes.add(node);

            for(int it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}