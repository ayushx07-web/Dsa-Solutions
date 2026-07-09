class Pair{
    int row;
    int col;
    int ht;
    Pair(int row, int col ,int ht){
        this.row = row;
        this.col = col;
        this.ht = ht;
    }
}
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[][] height = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    queue.add(new Pair(i,j,0));
                    vis[i][j]=1;
                    height[i][j]=0;
                }
            }
        }
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int h = queue.peek().ht;
            queue.remove();
            for(int i=0;i<4;i++){
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && vis[nRow][nCol]==0){
                    vis[nRow][nCol] = 1;
                    height[nRow][nCol] = h+1;
                    queue.add(new Pair(nRow,nCol,h+1));
                }
            }
        }
        return height;
    }
}