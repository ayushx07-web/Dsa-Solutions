class Solution {
    public int minimumDeletions(String s) {
        int countb=0;
        int delete = 0;

        for(char ch : s.toCharArray()){
            if(ch=='b'){
                countb++;
            }else{
                delete = Math.min(delete+1,countb);
            }
        }
        return delete;
    }
}