class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int total = 0;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
            total = lsum;
        }
        
        int right = cardPoints.length-1;
        for(int j=k-1;j>=0;j--){
            lsum-=cardPoints[j];
            rsum+=cardPoints[right];
            right--;

            total = Math.max(total,lsum+rsum);
        }
        return total;
    }
}