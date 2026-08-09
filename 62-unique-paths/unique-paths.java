class Solution {
    private int solve(int i,int j,int n,int m,int[][] t){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;
        if(t[i][j]!=-1) return t[i][j];
        int up = solve(i-1,j,n,m,t);
        int left = solve(i,j-1,n,m,t);
        int ans = up + left;
        return t[i][j] = ans;
    }
    public int uniquePaths(int m, int n) {
        int[][] t = new int[m+1][n+1];
        for(int[] i : t){
            Arrays.fill(i,-1);
        }
        return solve(m-1,n-1,n,m,t);
    }
}