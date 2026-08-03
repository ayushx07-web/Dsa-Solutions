class Solution {
    private void LCS(String s1,String s2,int n,int m,int[][]t){
        
        
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
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] t = new int[n+1][m+1];
        LCS(str1,str2,n,m,t);
        StringBuilder ans = new StringBuilder();
       int i=n,j=m;
       while(i>0 && j>0){
        if(str1.charAt(i-1)==str2.charAt(j-1)){
           ans.append(str1.charAt(i-1));
           i--;
           j--;
        }else{
            if(t[i][j-1]>t[i-1][j]){
                ans.append(str2.charAt(j-1));
                j--;
            }else{
                ans.append(str1.charAt(i-1));
                i--;
            }
        }
       }
       while(i > 0){
       ans.append(str1.charAt(i-1));
       i--;
}

      while(j > 0){
      ans.append(str2.charAt(j-1));
      j--;
}
       return ans.reverse().toString();
    }
}