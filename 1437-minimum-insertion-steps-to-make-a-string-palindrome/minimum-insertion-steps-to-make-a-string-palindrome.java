class Solution {
    private int lcs(String str1 , String str2, int n,int m,int[][]t){
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0) t[i][j] = 0;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }

    private int lps(String s,int n){
       
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] t = new int[n+1][n+1];
        return lcs(s,s2,n,n,t);
    }
    public int minInsertions(String s) {
         int n = s.length();
         int k = lps(s,n);
         return n - k;
    }
}