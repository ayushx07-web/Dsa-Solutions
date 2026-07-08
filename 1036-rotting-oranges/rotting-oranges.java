class Pair{
    int row;
    int col;
    int tm;
    Pair(int row,int col,int tm){
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }

                if(grid[i][j]==1) cntFresh++;
            }
        }

        int time = 0;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int count=0;
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().tm;
            time = Math.max(time,t);
            queue.remove();
            for(int i=0;i<4;i++){
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && vis[nRow][nCol]==0){
                    queue.add(new Pair(nRow,nCol,t+1));
                    vis[nRow][nCol] = 2;
                    count++;
                }
            }
        }

        if(count!=cntFresh) return -1;
        return time;
    }
}