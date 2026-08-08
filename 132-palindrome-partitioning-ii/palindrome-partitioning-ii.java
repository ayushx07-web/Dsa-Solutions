class Solution {
    private int solve(String s,int i,int[] t,boolean[][] pal){
        if(i==s.length())return 0;
        if(t[i]!=-1) return t[i];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<s.length();k++){
            if(pal[i][k]){
            
            int temp = solve(s,k+1,t,pal) + 1;
            if(temp<min){
                min = temp;
            }
        }
    }
          
     return t[i] = min;
    }
  
    public int minCut(String s) {
     int n= s.length();
     
     boolean[][] pal = new boolean[n+1][n+1];
     for(int i=n-1;i>=0;i--){
        for(int j=i;j<n;j++){
            if(s.charAt(i)==s.charAt(j) && (j-i<=2 || pal[i+1][j-1])) pal[i][j] =true;
        }
     }


    int[] t = new int[n+1];
     Arrays.fill(t,-1);
        return solve(s,0,t,pal) -1 ;
    }
}