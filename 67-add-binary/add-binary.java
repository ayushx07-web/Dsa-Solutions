class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1;
        String result="";
        int carry=0;

        while(i>=0 || j>=0){
            char ach = (i>=0)?a.charAt(i):'0';

            char bch = (j>=0)?b.charAt(j):'0';

            if((ach=='0' && bch=='1' && carry==0) || (ach=='1' && bch=='0' && carry==0)||(ach=='0' && bch=='0' && carry==1)){
                result='1'+result;
                carry=0;
            }
            else if((ach=='1' && bch=='1' && carry==0) || (ach=='1' && bch=='0' && carry==1)||(ach=='0' && bch=='1' && carry==1)){
            result='0'+result;
            carry=1;
            }
            else if(ach=='1' && bch=='1' && carry==1){
                result='1'+result;
                carry =1;
            }
            else if(ach=='0' && bch=='0' && carry==0){
                result='0'+result;
                carry =0;
            }
            i--;
            j--;
        }
         if(carry==1){
                result="1"+result;
            }
            return result;
    }
}