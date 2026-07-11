class Solution {
     private boolean bfs(int start,int graph[][],int color[]){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        color[start] = 0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();

            for(int neighbour : graph[node]){
                if(color[neighbour]==-1){
                    color[neighbour] = 1-color[node];
                    queue.add(neighbour);
                }else if(color[neighbour]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int vertices = graph.length;
        int[] color = new int[vertices];
        Arrays.fill(color,-1);

        for(int i=0;i<vertices;i++){
            if(color[i]==-1){
                if(bfs(i,graph,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
}