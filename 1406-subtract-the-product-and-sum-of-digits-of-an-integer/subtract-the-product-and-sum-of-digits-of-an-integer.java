class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int prod = 1;
        int result = 0;
        while(n>0){
           int digit = n%10;
           n = n/10;
           prod = prod * digit;
           sum = sum + digit;
           result = prod - sum;
        }
       return result;
    }
}