class Solution {
    private int lcs(String s1,String s2,int n,int m,int[][] t){
       for(int i=0;i<n+1;i++){
        for(int j=0;j<m+1;j++){
            if(i==0 || j==0) t[i][j] = 0;
        }
       }

       for(int i=1;i<n+1;i++){
        for(int j=1;j<m+1;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                t[i][j] = 1 + t[i-1][j-1];
            }else{
                t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
            }
        }
       }
       return t[n][m];
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] t = new int[n+1][m+1];
       int len = lcs(word1,word2,n,m,t);

        return n + m - 2*len;

    }
}