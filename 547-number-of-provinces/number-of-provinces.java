class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];

        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                count++;
                dfs(isConnected,visited,i);
            }
        }
        return count;
    }

    private static void dfs(int[][]isConnected,boolean[] visited,int node){
        visited[node] = true;
        for(int i=0;i<isConnected.length;i++){
          if(isConnected[node][i]==1 && !visited[i]){
            dfs(isConnected,visited,i);
          }
        }
    }
}