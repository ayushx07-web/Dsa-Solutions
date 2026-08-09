class Solution {
    private int solve(int i,int j,int[][] matrix,int[][] t){
        if(j<0 || j>=matrix.length) return Integer.MAX_VALUE;
        if(i==matrix.length-1) return matrix[i][j];
        if(t[i][j]!=Integer.MAX_VALUE) return t[i][j];

        int down = solve(i+1,j,matrix,t);
        int leftd = solve(i+1,j-1,matrix,t);
        int rightd = solve(i+1,j+1,matrix,t);
        int ans = matrix[i][j] + Math.min(down,Math.min(leftd,rightd));
        return t[i][j] = ans;
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] t = new int[n+1][n+1];
        for(int[] i : t){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
          int ans = Integer.MAX_VALUE;
          for(int j=0;j<n;j++){
            ans = Math.min(ans,solve(0,j,matrix,t));
          }
          return ans;
    }
}